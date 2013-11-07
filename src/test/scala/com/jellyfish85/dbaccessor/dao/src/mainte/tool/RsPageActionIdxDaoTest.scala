package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsPageActionIdxBean


class RsPageActionIdxDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsPageActionIdxDao

  "return true" should {
    db.connect

    val bean00: RsPageActionIdxBean  = new RsPageActionIdxBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"
    bean00.projectNameAttr.value  = "com.jellyfish85"
    bean00.actionNameAttr.value   = "my.action"
    bean00.headRevisionAttr.value = new BigDecimal(0)

    //delete
    dao.delete(db.conn, bean00)
    val list01: List[RsPageActionIdxBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for delete all records from RS_PAGE_ACTION_IDX" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    val bean01: RsPageActionIdxBean = dao.find(db.conn, bean00).head
    db.jCommit

    "return true for insert one record to RS_PAGE_ACTION_IDX" in {
      bean01.pathAttr.value must beEqualTo("sample/sample.java")
      bean01.actionNameAttr.value   = "my.action"
      bean01.fileNameAttr.value must beEqualTo("sample.java")
      bean01.projectNameAttr.value must beEqualTo("com.jellyfish85")
      bean01.headRevisionAttr.value must beEqualTo(new BigDecimal(0))
    }

    val bean02: RsPageActionIdxBean  = new RsPageActionIdxBean
    bean02.pathAttr.value         = "sample/sample.java"
    bean02.actionNameAttr.value   = "my.action"
    bean02.fileNameAttr.value     = "hoge.java"
    bean02.projectNameAttr.value  = "com.hogehoge85"
    bean02.headRevisionAttr.value = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsPageActionIdxBean  = dao.find(db.conn, bean02).head
    "return true for update one record to RS_PAGE_ACTION_IDX" in {
      bean03.pathAttr.value must beEqualTo("sample/sample.java")
      bean03.actionNameAttr.value must beEqualTo("my.action")
      bean03.fileNameAttr.value must beEqualTo("hoge.java")
      bean03.projectNameAttr.value must beEqualTo("com.hogehoge85")
      bean03.headRevisionAttr.value must beEqualTo(new BigDecimal(1))
    }

  }
}
