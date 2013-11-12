package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTablesBean

class RsSqlTablesDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSqlTablesDao

  "return true" should {
    db.connect

    val bean00: RsSqlTablesBean  = new RsSqlTablesBean
    bean00.pathAttr.value          = "sample/sample.java"
    bean00.fileNameAttr.value      = "sample.java"
    bean00.projectNameAttr.value   = "com.jellyfish85"
    bean00.persisterNameAttr.value = "sample.persister"
    bean00.headRevisionAttr.value  = new BigDecimal(0)

    //delete
    dao.delete(db.conn, bean00)

    val list01: List[RsSqlTablesBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SQLTABLES" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSqlTablesBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQLTABLES" in {
      bean01.pathAttr.value            must beEqualTo("sample/sample.java")
      bean01.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean01.persisterNameAttr.value   must beEqualTo("sample.persister")
      bean01.headRevisionAttr.value    must beEqualTo(new BigDecimal(0))
    }

    val bean02: RsSqlTablesBean  = new RsSqlTablesBean
    bean02.pathAttr.value          = "sample/sample.java"
    bean02.fileNameAttr.value      = "sample.java"
    bean02.projectNameAttr.value   = "com.jellyfish85"
    bean02.persisterNameAttr.value = "sample.persister"
    bean02.headRevisionAttr.value  = new BigDecimal(1)

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSqlTablesBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQLTABLES" in {
      bean03.pathAttr.value            must beEqualTo("sample/sample.java")
      bean03.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean03.headRevisionAttr.value    must beEqualTo(new BigDecimal(1))
    }
  }
}
