package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsTablesBean

class MsTablesDaoTest extends Specification {

  "return true" should {
    val db = new DatabaseManager
    val dao: MsTablesDao = new MsTablesDao

    db.connect

    val bean01: MsTablesBean = new MsTablesBean

    bean01.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
    bean01.logicalTableNameAttr.value = "トラン_KK_顧客_基本"
    bean01.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean01.revisionAttr.value = new java.math.BigDecimal(1)
    bean01.trkmIdAttr.value   = new BigDecimal(1)
    bean01.tabDefIdAttr.value = new BigDecimal(1)

    val list: List[MsTablesBean] = List(bean01)
    dao.delete(db.conn, bean01)
    dao.insert(db.conn, list)

    db.jCommit
    db.jClose

    val _bean: MsTablesBean  = new MsTablesBean
    _bean.physicalTableNameAttr.value =  "_T_KK_KOKYK_KHN"

    db.connect
    val bean: MsTablesBean = dao.find(db.conn, _bean)(0)
    db.jClose

    //顧客基本テーブルを指定してエンティティが取得できることを確認する
    "return true for _T_KK_KOKYK_KHN" in {
      val _bean: MsTablesBean = new MsTablesBean
      _bean.physicalTableNameAttr.value = "_T_KK_KOKYK_KHN"
      _bean.logicalTableNameAttr.value  = "トラン_KK_顧客_基本"

      bean.physicalTableNameAttr.value must beEqualTo(_bean.physicalTableNameAttr.value)
      bean.logicalTableNameAttr.value  must beEqualTo(_bean.logicalTableNameAttr.value)
    }
  }
}