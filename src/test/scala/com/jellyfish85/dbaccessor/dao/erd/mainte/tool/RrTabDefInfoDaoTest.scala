package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrTabDefInfoBean

import java.math.BigDecimal

/**
 * == RrTabDefInfoDaoTest ==
 *
 */
class RrTabDefInfoDaoTest extends Specification {
  val db: DatabaseManager  = new DatabaseManager
  val dao: RrTabDefInfoDao = new RrTabDefInfoDao

  "return true" should {
    db.connect

    val bean00: RrTabDefInfoBean = new RrTabDefInfoBean
    bean00.tabDefIdAttr.value          = new BigDecimal(1)
    bean00.tabDefRevisionAfAttr.value  = new BigDecimal(9999999999L)
    bean00.tabDefNameAttr.value        = "TABLE_DEFINE.xls"
    bean00.logicalTableNameAttr.value  = "サンプル"
    bean00.physicalTableNameAttr.value = "SAMPLE"
    bean00.columnIdAttr.value          = new BigDecimal(1)
    bean00.logicalColumnNameAttr.value = "SAMPLE_COLUMN"

    dao.delete(db.conn, bean00)
    val result: Int = dao.insert(db.conn, List(bean00))
    db.jCommit
    "return 1 for insert result" in {
      result must beEqualTo(1)
    }

    val bean01: RrTabDefInfoBean = dao.find(db.conn, bean00).head
    db.jClose
    "return true for RrTabDefInfoBean" in {
      bean01.tabDefRevisionAfAttr.value must equalTo(new BigDecimal(9999999999L))
      bean01.tabDefNameAttr.value       must equalTo("TABLE_DEFINE.xls")
    }
  }

}
