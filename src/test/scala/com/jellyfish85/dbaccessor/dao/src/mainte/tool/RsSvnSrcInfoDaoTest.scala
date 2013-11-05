package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.src.mainte.tool.RsSvnSrcInfoBean

class RsSvnSrcInfoDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSvnSrcInfoDao

  "return true" should {
    db.connect

    val bean00: RsSvnSrcInfoBean  = new RsSvnSrcInfoBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"
    bean00.projectNameAttr.value  = "com.jellyfish85"
    bean00.headRevisionAttr.value = new BigDecimal(0)

    //delete
    dao.deleteAll(db.conn)
    val list01: List[RsSvnSrcInfoBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for insert one record to RS_SVN_SRC_INFO" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSvnSrcInfoBean = dao.find(db.conn, bean00).head
    "return 1 for insert one record to RS_SVN_SRC_INFO" in {
      bean01.fileNameAttr.value must beEqualTo("sample.java")
    }

    val bean02: RsSvnSrcInfoBean = new RsSvnSrcInfoBean
    bean02.pathAttr.value         = "sample/sample.java"
    bean02.fileNameAttr.value     = "hoge.java"
    bean02.projectNameAttr.value  = "com.jellyfish85"
    bean02.headRevisionAttr.value = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSvnSrcInfoBean = dao.find(db.conn, bean00).head
    "return true for update  RS_SVN_SRC_INFO" in {
      bean03.fileNameAttr.value must beEqualTo("hoge.java")
      bean03.headRevisionAttr.value must beEqualTo(new BigDecimal(1))
    }

    //merge
    val bean04: RsSvnSrcInfoBean = new RsSvnSrcInfoBean
    bean04.pathAttr.value         = "sample/sample.java"
    bean04.fileNameAttr.value     = "fuga.java"
    bean04.projectNameAttr.value  = "com.jellyfish85"
    bean04.headRevisionAttr.value = new BigDecimal(2)

    dao.merge(db.conn, bean04)
    db.jCommit

    val bean05: RsSvnSrcInfoBean = dao.find(db.conn, bean00).head
    "return true for merge  RS_SVN_SRC_INFO" in {
      bean05.fileNameAttr.value must beEqualTo("fuga.java")
      bean05.headRevisionAttr.value must beEqualTo(new BigDecimal(2))
    }
  }

  "return SQLException for RS_SVN_SRC_INFO.PATH IS NULL" should {
    db.connect

    val bean00: RsSvnSrcInfoBean    = new RsSvnSrcInfoBean
    bean00.authorAttr.value = "Mr.hoge"

    dao.deleteAll(db.conn)
    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]
  }
}
