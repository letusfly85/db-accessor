package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTextExpBean

class RsSqlTextExpDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSqlTextExpDao

  "return true" should {
    db.connect

    val bean00: RsSqlTextExpBean  = new RsSqlTextExpBean
    bean00.pathAttr.value          = "sample/sample.java"
    bean00.fileNameAttr.value      = "sample.java"
    bean00.projectNameAttr.value   = "com.jellyfish85"
    bean00.subLineAttr.value       = new BigDecimal(0)
    bean00.lineAttr.value          = new BigDecimal(1)
    bean00.textAttr.value          = "sample.text"
    bean00.headRevisionAttr.value  = new BigDecimal(0)

    //delete
    dao.delete(db.conn, bean00)

    val list01: List[RsSqlTextExpBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SQL_TEXT_EXP" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSqlTextExpBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT_EXP" in {
      bean01.pathAttr.value            must beEqualTo("sample/sample.java")
      bean01.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean01.subLineAttr.value         must beEqualTo(new BigDecimal(0))
      bean01.lineAttr.value            must beEqualTo(new BigDecimal(1))
      bean01.textAttr.value            must beEqualTo("sample.text")
      bean01.headRevisionAttr.value    must beEqualTo(new BigDecimal(0))
    }

    val bean02: RsSqlTextExpBean  = new RsSqlTextExpBean
    bean02.pathAttr.value          = "sample/sample.java"
    bean02.fileNameAttr.value      = "sample.java"
    bean02.projectNameAttr.value   = "com.jellyfish85"
    bean02.subLineAttr.value       = new BigDecimal(0)
    bean02.lineAttr.value          = new BigDecimal(1)
    bean02.textAttr.value          = "sample.text"
    bean02.headRevisionAttr.value  = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSqlTextExpBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT_EXP" in {
      bean03.pathAttr.value            must beEqualTo("sample/sample.java")
      bean03.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean03.headRevisionAttr.value    must beEqualTo(new BigDecimal(1))
    }

    val bean04: RsSqlTextExpBean  = new RsSqlTextExpBean
    bean04.pathAttr.value          = "sample/sample.java"
    bean04.fileNameAttr.value      = "sample.java"
    bean04.projectNameAttr.value   = "com.jellyfish85"
    bean04.subLineAttr.value       = new BigDecimal(0)
    bean04.lineAttr.value          = new BigDecimal(2)
    bean04.textAttr.value          = "hoeg.text"
    bean04.headRevisionAttr.value  = new BigDecimal(2)

    dao.delete(db.conn, bean00)
    dao.insert(db.conn, List(bean03, bean04))
    db.jCommit

    val bean05: RsSqlTextExpBean = dao.findSummary(db.conn).head
    "return true for find summary record of RS_SQL_TEXT_EXP" in {
      bean05.pathAttr.value            must beEqualTo("sample/sample.java")
      bean05.subLineAttr.value         must beEqualTo(new BigDecimal(0))
    }

  }
}
