package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import java.math.BigDecimal

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.{RrTabColumnsBean}

class RrTabColumnsDaoTest extends Specification {
  val db = new DatabaseManager
  val dao: RrTabColumnsDao = new RrTabColumnsDao

  "return true" should {
    db.connect

    val bean00: RrTabColumnsBean = new RrTabColumnsBean
    bean00.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean00.tableIdAttr.value = new BigDecimal(1)

    // 削除系処理テスト
    dao.delete(db.conn, bean00)
    db.jCommit

    val list_del: List[RrTabColumnsBean] = dao.find(db.conn, bean00)
    "return 0 for _T_KK_KOKYK_KHN Columns" in {
      list_del.size must beEqualTo(0)
    }

    /*
    val bean01: RrTabColumnsBean = new RrTabColumnsBean
    val bean02: RrTabColumnsBean = new RrTabColumnsBean
    val bean03: RrTabColumnsBean = new RrTabColumnsBean

    bean01.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean02.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean03.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"

    bean01.logicalTableNameAttr.value = "顧客基本"
    bean02.logicalTableNameAttr.value = "顧客基本"
    bean03.logicalTableNameAttr.value = "顧客基本"


    bean01.tableIdAttr.value = new java.math.BigDecimal(1)
    bean02.tableIdAttr.value = new java.math.BigDecimal(1)
    bean03.tableIdAttr.value = new java.math.BigDecimal(1)

    bean01.revisionAfAttr.value = new java.math.BigDecimal(1)
    bean02.revisionAfAttr.value = new java.math.BigDecimal(1)
    bean03.revisionAfAttr.value = new java.math.BigDecimal(1)

    bean01.revisionBfAttr.value = new java.math.BigDecimal(1)
    bean02.revisionBfAttr.value = new java.math.BigDecimal(1)
    bean03.revisionBfAttr.value = new java.math.BigDecimal(1)

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

    val list: List[RrTabColumnsBean] = List(bean01, bean02, bean03)
    dao.insert(db.conn, list)

    db.jCommit
    */

  }

}
