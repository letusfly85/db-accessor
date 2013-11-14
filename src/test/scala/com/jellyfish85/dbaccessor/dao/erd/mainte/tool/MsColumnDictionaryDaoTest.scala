package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsColumnDictionaryBean

class MsColumnDictionaryDaoTest extends Specification {

  val db = new DatabaseManager
  val dao = new MsColumnDictionaryDao

  "return true" should {
    db.connect

    val bean01: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean01.dictColumnIdAttr.value       = new BigDecimal(0)
    bean01.physicalColumnNameAttr.value = "my.column"
    bean01.dataTypeAttr.value           = "my.type"
    bean01.dataLengthAttr.value         = "0"
    bean01.dataDefaultAttr.value        = "my.default"

    dao.delete(db.conn, bean01)
    db.jCommit
    val list00: List[MsColumnDictionaryBean] = dao.find(db.conn, bean01)
    "return 0 record for MS_COLUMN_DICTIONARY" in {
      list00 must beEmpty
    }

    val res01 = dao.insert(db.conn, List(bean01))
    db.jCommit
    "return one record for MS_COLUMN_DICTIONARY" in {
      res01 must beEqualTo(1)
    }

    val bean02: MsColumnDictionaryBean = dao.find(db.conn, bean01).head
    "return one recod for INSERT MS_COLUMN_DICTIONARY Columns" in {
      bean02.physicalColumnNameAttr.value must beEqualTo("my.column")
      bean02.dictColumnIdAttr.value       must beEqualTo(new BigDecimal(0))
      bean02.dataTypeAttr.value           must beEqualTo("my.type")
      bean02.dataLengthAttr.value         must beEqualTo("0")
      bean02.dataDefaultAttr.value        must beEqualTo("my.default")
    }

    val bean03: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean03.dictColumnIdAttr.value       = new BigDecimal(0)
    bean03.physicalColumnNameAttr.value = "my.column"
    bean03.dataTypeAttr.value           = "hoge.type"
    bean03.dataLengthAttr.value         = "0"
    bean03.dataDefaultAttr.value        = "hoge.default"

    dao.update(db.conn, List(bean03))
    db.jCommit

    val bean04: MsColumnDictionaryBean = dao.find(db.conn, bean01).head
    "return one recod for UPDATE MS_COLUMN_DICTIONARY Columns" in {
      bean04.physicalColumnNameAttr.value must beEqualTo("my.column")
      bean04.dictColumnIdAttr.value       must beEqualTo(new BigDecimal(0))
      bean04.dataTypeAttr.value           must beEqualTo("hoge.type")
      bean04.dataLengthAttr.value         must beEqualTo("0")
      bean04.dataDefaultAttr.value        must beEqualTo("hoge.default")
    }

    val bean05: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean05.dictColumnIdAttr.value       = new BigDecimal(0)
    bean05.physicalColumnNameAttr.value = "my.column"
    bean05.dataTypeAttr.value           = "hoge.type"
    bean05.dataLengthAttr.value         = "0"
    bean05.dataDefaultAttr.value        = "hoge.default"

    dao.merge(db.conn, bean05)
    db.jCommit

    val bean06: MsColumnDictionaryBean = dao.find(db.conn, bean01).head
    "return one recod for MERGE MS_COLUMN_DICTIONARY Columns" in {
      bean06.physicalColumnNameAttr.value must beEqualTo("my.column")
      bean06.dictColumnIdAttr.value       must beEqualTo(new BigDecimal(0))
      bean06.dataTypeAttr.value           must beEqualTo("hoge.type")
      bean06.dataLengthAttr.value         must beEqualTo("0")
      bean06.dataDefaultAttr.value        must beEqualTo("hoge.default")
    }
  }

  "return error" should {
    db.connect

    val bean01: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean01.dictColumnIdAttr.value       = new BigDecimal(0)
    bean01.dataTypeAttr.value           = "my.type"
    bean01.dataLengthAttr.value         = "0"
    bean01.dataDefaultAttr.value        = "my.default"

    dao.delete(db.conn, bean01)
    db.jCommit
    (dao.insert(db.conn, List(bean01))) must throwA[SQLException]


    val bean02: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean02.dictColumnIdAttr.value       = new BigDecimal(0)
    bean02.physicalColumnNameAttr.value = "my.column"
    bean02.dataTypeAttr.value           = "my.type"
    bean02.dataLengthAttr.value         = "0"
    bean02.dataDefaultAttr.value        = "my.default"


    val bean03: MsColumnDictionaryBean = new MsColumnDictionaryBean

    bean03.dictColumnIdAttr.value       = new BigDecimal(0)
    bean03.physicalColumnNameAttr.value = "my.column"
    bean03.dataTypeAttr.value           = "my.type"
    bean03.dataLengthAttr.value         = "0"
    bean03.dataDefaultAttr.value        = "my.default"

    (dao.insert(db.conn, List(bean02,bean03))) must throwA[SQLException]
  }
}