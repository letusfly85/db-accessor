package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndexesBean
import java.math.BigDecimal
import java.sql.SQLException

class MsIndexesDaoTest extends Specification {
  val db = new DatabaseManager
  val dao: MsIndexesDao = new MsIndexesDao

  "return true" should {
    db.connect

    val bean01: MsIndexesBean = new MsIndexesBean

    bean01.indexNameAttr.value = "_IX01_T_KK_KOKYK_KHN"
    bean01.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean01.revisionAttr.value = new java.math.BigDecimal(1)
    bean01.tabDefIdAttr.value = new BigDecimal(1)
    bean01.ticketNumberAttr.value = new BigDecimal(1)

    val list: List[MsIndexesBean] = List(bean01)
    dao.delete(db.conn, bean01)
    dao.insert(db.conn, list)

    db.jCommit
    db.jClose

    var bean: MsIndexesBean = new MsIndexesBean
    bean.indexNameAttr.value = "_IX01_T_KK_KOKYK_KHN"

    db.connect
    bean = dao.find(db.conn, bean)(0)

    "return true for _IX01_T_KK_KOKYK_KHN" in {

      bean.indexNameAttr.value must beEqualTo("_IX01_T_KK_KOKYK_KHN")
      bean.tableIdAttr.value   must beEqualTo(new java.math.BigDecimal(1) )

    }
  }

  "return error for MS_INDEXES.TICKET_NUMBER IS NULL" should {
    db.connect

    val bean01: MsIndexesBean = new MsIndexesBean

    bean01.indexNameAttr.value = "_IX01_T_KK_KOKYK_KHN"
    bean01.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean01.revisionAttr.value = new java.math.BigDecimal(1)
    bean01.tabDefIdAttr.value = new BigDecimal(1)

    val list: List[MsIndexesBean] = List(bean01)
    dao.delete(db.conn, bean01)

    {dao.insert(db.conn, list)} must throwA[SQLException]
  }
}
