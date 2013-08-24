package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndColumnsBean

import java.math.BigDecimal

/**
 * == MsIndColumnsDaoTest ==
 *
 *
 */
class MsIndColumnsDaoTest extends Specification {
  val db  = new DatabaseManager
  val dao = new MsIndColumnsDao

  "return true" should {
    db.connect

    /**
     *
     * {{
     * 	INDEX_NAME			VARCHAR2(30)	NOT NULL,
     * 	REVISION			NUMBER(38,0)	NOT NULL,
     * 	TABLE_ID			NUMBER(38,0)	NOT	NULL,
     * 	COLUMN_ID			NUMBER(38,0)	NOT NULL,
     * 	COLUMN_NAME			VARCHAR2(30)	NOT	NULL,
     * 	COLUMN_POSITION		NUMBER(38,0)	NOT NULL,
     * 	}}
     *
     */
    // bean for insert
    val bean00: MsIndColumnsBean = new MsIndColumnsBean
    bean00.indexNameAttr.value      = "_IX01_T_KK_KOKYK_KHN"
    bean00.revisionAttr.value       = new BigDecimal(0)
    bean00.tableIdAttr.value        = new BigDecimal(0)
    bean00.columnIdAttr.value       = new BigDecimal(1)
    bean00.columnPositionAttr.value = new BigDecimal(1)
    bean00.columnNameAttr.value     = "KANRITEN_NO"

    // bean for find, delete, update
    val beanXX: MsIndColumnsBean = new MsIndColumnsBean
    beanXX.indexNameAttr.value      = "_IX01_T_KK_KOKYK_KHN"

    dao.delete(db.conn, bean00)
    dao.insert(db.conn, List(bean00))
    db.jCommit

    // result bean
    val _bean: MsIndColumnsBean = dao.find(db.conn, beanXX).head
    "return KANRITEN_NO for _IX01_T_KK_KOKYK_KHN's index key" in {
       _bean.columnNameAttr.value must beEqualTo("KANRITEN_NO")
    }

    dao.delete(db.conn, beanXX)
    db.jCommit

    val _list: List[MsIndColumnsBean] = dao.find(db.conn, beanXX)
    "return empty for after deleting _IX01_T_KK_KOKYK_KHN" in {
      _list.size must beEqualTo(0)
    }


  //TODO update

  //TODO select

  }


  //TODO exception


}
