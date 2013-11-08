package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlCdataBean

class RsSqlCdataDaoTest extends  Specification {

  val db  = new DatabaseManager
  val dao = new RsSqlCdataDao

  "return true" should {
    db.connect

    val bean00: RsSqlCdataBean  = new RsSqlCdataBean
    bean00.pathAttr.value          = "sample/sample.java"
    bean00.fileNameAttr.value      = "sample.java"
    bean00.projectNameAttr.value   = "com.jellyfish85"
    bean00.persisterNameAttr.value = "sample.persister"
    bean00.lineAttr.value          = new BigDecimal(1)
    bean00.textAttr.value          = "sample.text"
    bean00.headRevisionAttr.value  = new BigDecimal(0)

    //truncate
    dao.truncate(db.conn)

    val list01: List[RsSqlCdataBean] = dao.find(db.conn, bean00)
    "return 0 for truncate table RS_SQL_CDATA" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSqlCdataBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_CDATA" in {
      bean01.pathAttr.value            must beEqualTo("sample/sample.java")
      bean01.projectNameAttr.value     must beEqualTo("com.jellyfish85")
      bean01.persisterNameAttr.value   must beEqualTo("sample.persister")
      bean01.lineAttr.value            must beEqualTo(new BigDecimal(1))
      bean01.textAttr.value            must beEqualTo("sample.text")
      bean01.headRevisionAttr.value    must beEqualTo(new BigDecimal(0))
    }
  }
}
