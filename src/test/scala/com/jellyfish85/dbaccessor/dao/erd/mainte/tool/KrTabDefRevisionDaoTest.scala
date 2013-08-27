package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.KrTabDefRevisionBean

import java.math.BigDecimal

/**
 * == KrTabDefRevisionDaoTest ==
 *
 *
 */
class KrTabDefRevisionDaoTest extends Specification {
  val db  = new DatabaseManager
  val dao = new KrTabDefRevisionDao

  "return true" should {
    db.connect

    /**
     * TAB_DEF_ID		    NOT NULL,
  	 * TAB_DEF_REVISION	NOT NULL
     *
     */
    val bean00: KrTabDefRevisionBean = new KrTabDefRevisionBean
    bean00.tabDefIdAttr.value         = new BigDecimal(0)
    bean00.tabDefNameAttr.value       = "TABLE_DEFINE_X.xls"
    bean00.svnRevisionAttr.value      = new BigDecimal(0)
    bean00.tabDefRevisionAttr.value   = new BigDecimal(0)
    bean00.svnPathAttr.value          = "path"
    bean00.lastUpdateYmdAttr.value    = "20130827"
    bean00.lastUpdateHhmissAttr.value = "220000"

    var result00: Int = dao.delete(db.conn, bean00)
    result00 = dao.insert(db.conn, List(bean00))
    db.jCommit

    "return 1 for insert one record to KR_TAB_DEF_REVISION" in {
      result00 must beEqualTo(1)
    }
    val bean01: KrTabDefRevisionBean = dao.find(db.conn, bean00).head
    "return true for TABLE_DEFINE_X.xls" in {
      bean01.tabDefIdAttr.value         must beEqualTo(new BigDecimal(0))
      bean01.tabDefNameAttr.value       must beEqualTo("TABLE_DEFINE_X.xls")
      bean01.svnRevisionAttr.value      must beEqualTo(new BigDecimal(0))
      bean01.svnPathAttr.value          must beEqualTo("path")
      bean01.lastUpdateYmdAttr.value    must beEqualTo("20130827")
      bean01.lastUpdateHhmissAttr.value must beEqualTo("220000")
    }

    bean00.svnPathAttr.value = "path2"
    val result01: Int = dao.update(db.conn, List(bean00))
    db.jCommit

    "return 1 for updagte one record to KR_TAB_DEF_REVISION" in {
      result01 must beEqualTo(1)
    }

    val bean02: KrTabDefRevisionBean = dao.find(db.conn, bean00).head
    db.jClose
    "return true for TABLE_DEFINE_X.xls" in {
      bean02.svnPathAttr.value          must beEqualTo("path2")
    }
  }
}