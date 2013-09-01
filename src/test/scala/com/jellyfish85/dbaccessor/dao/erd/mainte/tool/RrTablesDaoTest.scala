package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrTablesBean

import java.math.BigDecimal
import java.sql.SQLException

/**
 * == Over Veiw ==
 *
 * this class tests RrTablesDao
 * RrTablesDao is related to RR_TABLES, which don't allow null for below columns.
 *
 * TRKM_ID					    NUMBER(38,0)		NOT NULL,
 * TAB_DEF_ID			  	  NUMBER(38,0)		NOT NULL,
 * TABLE_ID				      NUMBER(38,0)		NOT NULL,
 * REVISION_AF			  	NUMBER(38,0)		NOT NULL,
 * REVISION_BF				  NUMBER(38,0)		NOT NULL,
 * LOGICAL_TABLE_NAME   VARCHAR2(200)		NOT NULL,
 * PHYSICAL_TABLE_NAME	VARCHAR2(30)		NOT NULL,
 */
class RrTablesDaoTest extends Specification {
  val db  = new DatabaseManager
  val dao = new RrTablesDao

  "return true" should {
    db.connect

    val bean00: RrTablesBean    = new RrTablesBean
    bean00.trkmIdAttr.value     = new BigDecimal(0)
    bean00.tabDefIdAttr.value   = new BigDecimal(0)
    bean00.tableIdAttr.value    = new BigDecimal(0)
    bean00.revisionAfAttr.value = new BigDecimal(0)
    bean00.revisionBfAttr.value = new BigDecimal(0)
    bean00.logicalTableNameAttr.value  = "サンプル"
    bean00.physicalTableNameAttr.value = "T_KS_TABLE_A"

    dao.delete(db.conn, bean00)
    val result00 = dao.insert(db.conn, List(bean00))
    db.jCommit

    //delete, insert and find test
    "return 1 for insert one record to KR_TAB_DEF_REVISION" in {
      result00 must beEqualTo(1)
    }
    val bean01: RrTablesBean = dao.find(db.conn, bean00).head
    "return true for T_KS_TABLE_A" in {
      bean01.trkmIdAttr.value       must beEqualTo(new BigDecimal(0))
      bean01.tabDefIdAttr.value     must beEqualTo(new BigDecimal(0))
      bean01.tableIdAttr.value      must beEqualTo(new BigDecimal(0))
      bean01.revisionAfAttr.value   must beEqualTo(new BigDecimal(0))
      bean01.revisionBfAttr.value   must beEqualTo(new BigDecimal(0))
      bean01.logicalTableNameAttr.value  must beEqualTo("サンプル")
      bean01.physicalTableNameAttr.value must beEqualTo("T_KS_TABLE_A")
    }

    //update and find test
    bean00.logicalTableNameAttr.value = "サンプル2"
    val result01: Int =  dao.update(db.conn, List(bean00))

    "return 1 for insert one record to KR_TAB_DEF_REVISION" in {
      result01 must beEqualTo(1)
    }

    val bean02: RrTablesBean = dao.find(db.conn, bean00).head
    db.jCommit
    db.jClose
    "return true for update T_KS_TABLE_A.LOGICAL_TABLE_NAME" in {
      bean02.logicalTableNameAttr.value must beEqualTo("サンプル2")
    }
  }

  "return SQLException for RR_TABLES.LOGICAL_TABLE_NAME IS NULL" should {
    db.connect

    val bean00: RrTablesBean    = new RrTablesBean
    bean00.trkmIdAttr.value     = new BigDecimal(0)
    bean00.tabDefIdAttr.value   = new BigDecimal(0)
    bean00.tableIdAttr.value    = new BigDecimal(0)
    bean00.revisionAfAttr.value = new BigDecimal(0)
    bean00.revisionBfAttr.value = new BigDecimal(0)
    bean00.physicalTableNameAttr.value = "T_KS_TABLE_A"

    dao.delete(db.conn, bean00)
    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]
  }

}