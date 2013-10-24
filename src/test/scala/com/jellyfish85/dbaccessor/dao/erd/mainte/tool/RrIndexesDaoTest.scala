package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import java.math.BigDecimal

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.{RrIndexesBean, MsIndexesBean}

class RrIndexesDaoTest extends Specification {
  val db = new DatabaseManager
  val dao = new RrIndexesDao

  "return true" should {
    db.connect

    val bean01: RrIndexesBean = new RrIndexesBean

    bean01.indexNameAttr.value = "_IX01_T_KK_KOKYK_KHN"
    bean01.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean01.revisionAfAttr.value = new java.math.BigDecimal(1)
    bean01.tabDefIdAttr.value = new BigDecimal(1)
    bean01.ticketNumberAttr.value = new BigDecimal(1)

    val list: List[RrIndexesBean] = List(bean01)
    dao.delete(db.conn, bean01)
    val res = dao.insert(db.conn, list)

    db.jCommit
    "return 1 for _IX01_T_KK_KOKYK_KHN Columns" in {
      res must beEqualTo(1)
    }

    val bean02: RrIndexesBean = dao.find(db.conn, bean01).head
    db.jClose
    "return 1 for _IX01_T_KK_KOKYK_KHN Columns" in {
      bean02.indexNameAttr.value must beEqualTo("_IX01_T_KK_KOKYK_KHN")
    }

  }

}
