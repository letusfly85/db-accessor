package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTextBean

class RsSqlTextDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSqlTextDao

  "return true" should {
    db.connect

    val bean00: RsSqlTextBean  = new RsSqlTextBean
    bean00.pathAttr.value          = "sample/sample.java"
    bean00.fileNameAttr.value      = "sample.java"
    bean00.projectNameAttr.value   = "com.jellyfish85"
    bean00.persisterNameAttr.value = "sample.persister"
    bean00.lineAttr.value          = new BigDecimal(1)
    bean00.textAttr.value          = "sample.text"
    bean00.headRevisionAttr.value  = new BigDecimal(0)

    //delete
    dao.delete(db.conn, bean00)

    val list01: List[RsSqlTextBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SQL_TEXT" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSqlTextBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT" in {
      bean01.pathAttr.value            must beEqualTo("sample/sample.java")
      bean01.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean01.persisterNameAttr.value   must beEqualTo("sample.persister")
      bean01.lineAttr.value            must beEqualTo(new BigDecimal(1))
      bean01.textAttr.value            must beEqualTo("sample.text")
      bean01.headRevisionAttr.value    must beEqualTo(new BigDecimal(0))
    }

    val bean02: RsSqlTextBean  = new RsSqlTextBean
    bean02.pathAttr.value          = "sample/sample.java"
    bean02.fileNameAttr.value      = "sample.java"
    bean02.projectNameAttr.value   = "com.jellyfish85"
    bean02.persisterNameAttr.value = "sample.persister"
    bean02.lineAttr.value          = new BigDecimal(1)
    bean02.textAttr.value          = "sample.text"
    bean02.headRevisionAttr.value  = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSqlTextBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT" in {
      bean03.pathAttr.value            must beEqualTo("sample/sample.java")
      bean03.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean03.headRevisionAttr.value    must beEqualTo(new BigDecimal(1))
    }

    val bean04: RsSqlTextBean  = new RsSqlTextBean
    bean04.pathAttr.value          = "sample/sample.java"
    bean04.fileNameAttr.value      = "sample.java"
    bean04.projectNameAttr.value   = "com.jellyfish85"
    bean04.persisterNameAttr.value = "sample.persister"
    bean04.lineAttr.value          = new BigDecimal(2)
    bean04.textAttr.value          = "hoeg.text"
    bean04.headRevisionAttr.value  = new BigDecimal(2)

    dao.delete(db.conn, bean00)
    dao.insert(db.conn, List(bean03, bean04))
    db.jCommit

    val bean05: RsSqlTextBean = dao.findSummary(db.conn).head
    "return true for find summary record of RS_SQL_TEXT" in {
      bean05.pathAttr.value            must beEqualTo("sample/sample.java")
      bean05.persisterNameAttr.value   must beEqualTo("sample.persister")
    }

  }
}