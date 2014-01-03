package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager

import java.math.BigDecimal
import java.sql.SQLException
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsErdReleasesBean

/**
 * == MsErdReleasesDaoTest ==
 * 
 * 
 * 
 */
class MsErdReleasesDaoTest extends Specification {
  
  val db:  DatabaseManager  = new DatabaseManager
  val dao: MsErdReleasesDao = new MsErdReleasesDao

  "return true" should {
    db.connect

    val bean00: MsErdReleasesBean  = new MsErdReleasesBean
    bean00.releaseIdAttr.value   = new BigDecimal(0)
    bean00.objectTypeAttr.value  = "TABLE"
    bean00.objectIdAttr.value	   = new BigDecimal(0)
    bean00.revisionAttr.value	   = new BigDecimal(0)
    bean00.objectNameAttr.value  = "my.object"
    bean00.diffTypeAttr.value	   = "X"

    //delete
    dao.delete(db.conn, bean00)
    db.jCommit
    val list01: List[MsErdReleasesBean] = dao.find(db.conn, bean00)
    "return 0 for delete table MS_ERD_RELEASES" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: MsErdReleasesBean = dao.find(db.conn, bean00).head
    "return true for insert one record to MS_ERD_RELEASES" in {
      bean01.releaseIdAttr.value   must beEqualTo(new BigDecimal(0))
      bean01.objectTypeAttr.value  must beEqualTo("TABLE")
      bean01.objectIdAttr.value	   must beEqualTo(new BigDecimal(0))
      bean01.revisionAttr.value	   must beEqualTo(new BigDecimal(0))
      bean01.objectNameAttr.value  must beEqualTo("my.object")
      bean01.diffTypeAttr.value	   must beEqualTo("X")
    }

    val bean02: MsErdReleasesBean  = new MsErdReleasesBean
    bean02.releaseIdAttr.value   = new BigDecimal(0)
    bean02.objectTypeAttr.value  = "TABLE"
    bean02.objectIdAttr.value	   = new BigDecimal(1)
    bean02.revisionAttr.value	   = new BigDecimal(0)
    bean02.objectNameAttr.value  = "my.object"
    bean02.diffTypeAttr.value	   = "Y"

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: MsErdReleasesBean = dao.find(db.conn, bean00).head
    "return true for insert one record to MS_ERD_RELEASES" in {
      bean03.releaseIdAttr.value   must beEqualTo(new BigDecimal(0))
      bean03.objectTypeAttr.value  must beEqualTo("TABLE")
      bean03.objectIdAttr.value	   must beEqualTo(new BigDecimal(1))
      bean03.revisionAttr.value	   must beEqualTo(new BigDecimal(0))
      bean03.objectNameAttr.value  must beEqualTo("my.object")
      bean03.diffTypeAttr.value	   must beEqualTo("Y")
    }
  }

}
