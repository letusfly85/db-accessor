package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import java.math.BigDecimal

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTabColumnsBean


class MsTabColumnsDaoTest extends Specification {

  "return true" should {
    val db = new DatabaseManager
    val dao: MsTabColumnsDao = new MsTabColumnsDao

    db.connect

    val bean01: MsTabColumnsBean = new MsTabColumnsBean
    val bean02: MsTabColumnsBean = new MsTabColumnsBean
    val bean03: MsTabColumnsBean = new MsTabColumnsBean

    bean01.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean02.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean03.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"

    bean01.logicalTableNameAttr.value = "顧客基本"
    bean02.logicalTableNameAttr.value = "顧客基本"
    bean03.logicalTableNameAttr.value = "顧客基本"


    bean01.tableIdAttr.value = new java.math.BigDecimal(1)
    bean02.tableIdAttr.value = new java.math.BigDecimal(1)
    bean03.tableIdAttr.value = new java.math.BigDecimal(1)

    bean01.revisionAttr.value = new java.math.BigDecimal(1)
    bean02.revisionAttr.value = new java.math.BigDecimal(1)
    bean03.revisionAttr.value = new java.math.BigDecimal(1)

    bean01.columnIdAttr.value = new java.math.BigDecimal(1)
    bean02.columnIdAttr.value = new java.math.BigDecimal(2)
    bean03.columnIdAttr.value = new java.math.BigDecimal(3)

    bean01.logicalColumnNameAttr.value = "顧客ID"
    bean02.logicalColumnNameAttr.value = "店番号"
    bean03.logicalColumnNameAttr.value = "CIF番号"

    bean01.physicalColumnNameAttr.value = "PK_KOKYK_ID"
    bean02.physicalColumnNameAttr.value = "TEN_NO"
    bean03.physicalColumnNameAttr.value = "CIF_NO"

    bean01.dataTypeAttr.value = "CHAR"
    bean01.dataLengthAttr.value = "8"

    val list: List[MsTabColumnsBean] = List(bean01, bean02, bean03)
    dao.delete(db.conn, bean01)
    dao.insert(db.conn, list)

    db.jCommit
    db.jClose

    var bean: MsTabColumnsBean = new MsTabColumnsBean
    bean.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"

    db.connect
    bean = dao.find(db.conn, bean)(0)
    db.jClose

    "return true for _T_KK_KOKYK_KHN.PK_KOKYK_ID" in {
      bean.physicalColumnNameAttr.value must beEqualTo("PK_KOKYK_ID")
      bean.dataTypeAttr.value           must beEqualTo("CHAR")
      bean.dataLengthAttr.value         must beEqualTo("8")
      bean.tableIdAttr.value            must beEqualTo(new BigDecimal(1))
    }

    val bean00: MsTabColumnsBean = new MsTabColumnsBean
    bean00.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean00.tableIdAttr.value = new java.math.BigDecimal(1)

    db.connect
    val _list: List[MsTabColumnsBean] = dao.find(db.conn, bean00)
    "return 3 for _T_KK_KOKYK_KHN Columns" in {
      _list.size must beEqualTo(3)
    }

    dao.delete(db.conn, bean00)
    db.jCommit

    val __list: List[MsTabColumnsBean] = dao.find(db.conn, bean00)

    db.jClose
    "return 0 for _T_KK_KOKYK_KHN Columns" in {
      __list.size must beEqualTo(0)
    }
  }
}
