package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTablesExpBean

class RsSqlTablesExpDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSqlTablesExpDao

  "return true" should {
    db.connect

    val bean00: RsSqlTablesExpBean  = new RsSqlTablesExpBean
    bean00.pathAttr.value          = "sample/sample.java"
    bean00.fileNameAttr.value      = "sample.java"
    bean00.projectNameAttr.value   = "com.jellyfish85"
    bean00.subLineAttr.value       = new BigDecimal(0)
    bean00.headRevisionAttr.value  = new BigDecimal(0)

    //truncate
    dao.truncate(db.conn)

    val list01: List[RsSqlTablesExpBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SQLTABLES_EXP" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSqlTablesExpBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQLTABLES_EXP" in {
      bean01.pathAttr.value            must beEqualTo("sample/sample.java")
      bean01.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean01.subLineAttr.value         must beEqualTo(new BigDecimal(0))
      bean01.headRevisionAttr.value    must beEqualTo(new BigDecimal(0))
    }

    val bean02: RsSqlTablesExpBean  = new RsSqlTablesExpBean
    bean02.pathAttr.value          = "sample/sample.java"
    bean02.fileNameAttr.value      = "sample.java"
    bean02.projectNameAttr.value   = "com.jellyfish85"
    bean02.subLineAttr.value       = new BigDecimal(0)
    bean02.headRevisionAttr.value  = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSqlTablesExpBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQLTABLES_EXP" in {
      bean03.pathAttr.value            must beEqualTo("sample/sample.java")
      bean03.subLineAttr.value         must beEqualTo(new BigDecimal(0))
      bean03.headRevisionAttr.value    must beEqualTo(new BigDecimal(1))
    }
  }

}
