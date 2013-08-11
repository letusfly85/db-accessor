package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndexesBean

class MsIndexesDaoTest extends Specification {
  val db = new DatabaseManager
  val dao: MsIndexesDao = new MsIndexesDao

  "return true" should {
    var bean: MsIndexesBean = new MsIndexesBean
    bean.indexNameAttr.value = "IX01_T_KK_KOKYK_KHN"

    db.connect
    bean = dao.find(db.conn, bean)(0)

    "return true for IX01_T_KK_KOKYK_KHN" in {

      bean.indexNameAttr.value must beEqualTo("IX01_T_KK_KOKYK_KHN")
      bean.tableIdAttr.value   must beEqualTo(new java.math.BigDecimal(382) )

    }

  }

}
