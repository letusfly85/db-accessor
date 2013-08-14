package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTabColumnsBean

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
      bean.tableIdAttr.value            must beEqualTo(382)
    }
  }
}
