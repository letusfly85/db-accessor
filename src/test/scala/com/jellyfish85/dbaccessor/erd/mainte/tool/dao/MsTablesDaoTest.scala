package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTablesBean
import com.jellyfish85.dbaccessor.manager.DatabaseManager

class MsTablesDaoTest extends Specification {
  val db = new DatabaseManager

  "return true" should {
    val dao: MsTablesDao = new MsTablesDao
    var bean: MsTablesBean  = new MsTablesBean
    bean.physicalTableNameAttr.value =  "T_KK_KOKYK_KHN"

    db.connect
    bean = dao.find(db.conn, bean)(0)
    db.jClose

    //顧客基本テーブルを指定してエンティティが取得できることを確認する
    "return true for T_KK_KOKYK_KHN" in {
      val _bean: MsTablesBean = new MsTablesBean
      _bean.physicalTableNameAttr.value = "T_KK_KOKYK_KHN"
      _bean.logicalTableNameAttr.value  = "トラン_KK_顧客_基本"

      bean.logicalTableNameAttr.value  must beEqualTo(_bean.logicalTableNameAttr.value)
    }
  }

}
