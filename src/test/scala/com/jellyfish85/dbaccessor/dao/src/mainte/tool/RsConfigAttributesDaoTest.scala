package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsConfigAttributesBean

class RsConfigAttributesDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsConfigAttributesDao

  "return true" should {
    db.connect

    val bean00: RsConfigAttributesBean  = new RsConfigAttributesBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"
    bean00.projectNameAttr.value  = "com.jellyfish85"
    bean00.actionNameAttr.value   = "my.action"
    bean00.subjectIdAttr.value    = "my.subjectid"
    bean00.headRevisionAttr.value = new BigDecimal(0)

    //delete
    dao.deleteAll(db.conn)
    val list01: List[RsConfigAttributesBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for delete All record to RS_CONFIG_ATTRIBUTE" in {
      list01.size must beEqualTo(0)
    }

    dao.insert(db.conn, List(bean00))
    db.jCommit
    val bean02: RsConfigAttributesBean = dao.find(db.conn, bean00).head
    "return 1 record for RS_CONFIG_ATTRIBUTE" in {
      bean02.pathAttr.value        must beEqualTo("sample/sample.java")
      bean02.fileNameAttr.value    must beEqualTo("sample.java")
    }

    bean00.projectNameAttr.value = "com.hogehoge85"
    dao.update(db.conn, List(bean00))
    db.jCommit
    val bean03: RsConfigAttributesBean = dao.find(db.conn, bean00).head
    "return 1 record for RS_CONFIG_ATTRIBUTE" in {
      bean03.pathAttr.value           must beEqualTo("sample/sample.java")
      bean03.fileNameAttr.value       must beEqualTo("sample.java")
      bean03.projectNameAttr.value    must beEqualTo("com.hogehoge85")
    }
  }
}
