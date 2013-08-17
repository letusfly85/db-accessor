package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTabColumnsBean
import java.math.BigDecimal

class MsTabColumnsDaoTest extends Specification {
  val db = new DatabaseManager
  val dao: MsTabColumnsDao = new MsTabColumnsDao

  "return true" should {
    var bean: MsTabColumnsBean = new MsTabColumnsBean
    bean.physicalTableNameAttr.value = "T_KK_KOKYK_KHN"

    db.connect
    bean = dao.find(db.conn, bean)(0)
    db.jClose

    "return true for T_KK_KOKYK_KHN.PK_KOKYK_ID" in {
      bean.physicalColumnNameAttr.value must beEqualTo("PK_KOKYK_ID")
      bean.dataTypeAttr.value           must beEqualTo("CHAR")
      bean.dataLengthAttr.value         must beEqualTo("8")
      bean.tableIdAttr.value            must beEqualTo(new BigDecimal(382))
    }

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

    val list: List[MsTabColumnsBean] = List(bean01, bean02, bean03)
    dao.insert(db.conn, list)

    val bean00: MsTabColumnsBean = new MsTabColumnsBean
    bean00.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"

    val _list: List[MsTabColumnsBean] = dao.find(db.conn, bean00)

    db.jRollback
    db.jClose

    "return 3 for _T_KK_KOKYK_KHN Columns" in {
      _list.size must beEqualTo(3)
    }
  }
}
