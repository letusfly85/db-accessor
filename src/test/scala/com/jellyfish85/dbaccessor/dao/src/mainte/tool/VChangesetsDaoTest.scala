package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.VChangesetsBean

class VChangesetsDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSvnSrcInfoDao

  "return true" should {
    db.connect

    val bean00: VChangesetsBean  = new VChangesetsBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"

    //delete
    dao.delete(db.conn, bean00)
    val list01: List[VChangesetsBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for insert one record to V_CHANGESETS" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: VChangesetsBean = dao.find(db.conn, bean00).head
    "return 1 for insert one record to V_CHANGESETS" in {
      bean01.fileNameAttr.value must beEqualTo("sample.java")
    }

    val bean02: VChangesetsBean = new VChangesetsBean
    bean02.pathAttr.value         = "sample/sample.java"
    bean02.fileNameAttr.value     = "hoge.java"

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: VChangesetsBean = dao.find(db.conn, bean00).head
    "return true for update  V_CHANGESETS" in {
      bean03.fileNameAttr.value must beEqualTo("hoge.java")
    }

    //merge
    val bean04: VChangesetsBean = new VChangesetsBean
    bean04.pathAttr.value         = "sample/sample.java"
    bean04.fileNameAttr.value     = "fuga.java"

    dao.merge(db.conn, bean04)
    db.jCommit

    val bean05: VChangesetsBean = dao.find(db.conn, bean00).head
    "return true for merge  V_CHANGESETS" in {
      bean05.fileNameAttr.value must beEqualTo("fuga.java")
    }
  }

  "return SQLException for V_CHANGESETS.PATH IS NULL" should {
    db.connect

    val bean00: VChangesetsBean    = new VChangesetsBean
    bean00.authorAttr.value = "Mr.hoge"

    dao.deleteAll(db.conn)
    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]
  }

}
