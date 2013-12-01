package com.jellyfish85.dbaccessor.dao.query.generate.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.query.generate.tool.KrObjectDependenciesBean

/**
 * == KrObjectDependenciesDaoTest ==
 *
 *
 * @author wada shunsuke
 * @since  2013/11/30
 * @todo
 *
 */
class KrObjectDependenciesDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new KrObjectDependenciesDao

  "return true" should {
    db.connect

    val bean00: KrObjectDependenciesBean  = new KrObjectDependenciesBean
    bean00.dependentGrpCdAttr.value     = "00"
    bean00.dependentCdAttr.value        = "000"
    bean00.refferedOwnerAttr.value      = "jellyfish85"
    bean00.objectOwnerAttr.value        = "scott"
    bean00.backupOwnerAttr.value        = "scott"
    bean00.ifFlgAttr.value              = "0"
    bean00.masterDataCheckFlgAttr.value = "0"

    //delete
    dao.delete(db.conn, bean00)
    val list01: List[KrObjectDependenciesBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for insert one record to KR_OBJECT_DEPENDENCIES" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: KrObjectDependenciesBean = dao.find(db.conn, bean00).head
    "return 1 for insert one record to KR_OBJECT_DEPENDENCIES" in {
      bean01.dependentGrpCdAttr.value must beEqualTo("00")
      bean01.dependentCdAttr.value must beEqualTo("000")
      bean01.refferedOwnerAttr.value must beEqualTo("jellyfish85")
      bean01.objectOwnerAttr.value must beEqualTo("scott")
      bean01.backupOwnerAttr.value must beEqualTo("scott")
      bean01.ifFlgAttr.value must beEqualTo("0")
      bean01.masterDataCheckFlgAttr.value must beEqualTo("0")
    }

    val bean02: KrObjectDependenciesBean = new KrObjectDependenciesBean
    bean02.dependentGrpCdAttr.value     = "00"
    bean02.dependentCdAttr.value        = "000"
    bean02.refferedOwnerAttr.value      = "jellyfish85"
    bean02.objectOwnerAttr.value        = "tiger"
    bean02.backupOwnerAttr.value        = "tiger"
    bean02.ifFlgAttr.value              = "0"
    bean02.masterDataCheckFlgAttr.value = "0"

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: KrObjectDependenciesBean = dao.find(db.conn, bean00).head
    "return true for update  KR_OBJECT_DEPENDENCIES" in {
      bean03.dependentGrpCdAttr.value must beEqualTo("00")
      bean03.dependentCdAttr.value must beEqualTo("000")
      bean03.refferedOwnerAttr.value must beEqualTo("jellyfish85")
      bean03.objectOwnerAttr.value must beEqualTo("tiger")
      bean03.backupOwnerAttr.value must beEqualTo("tiger")
      bean03.ifFlgAttr.value must beEqualTo("0")
      bean03.masterDataCheckFlgAttr.value must beEqualTo("0")
    }

  }

  "return SQLException for KR_OBJECT_DEPENDENCIES.DEPENDENT_CD IS NULL" should {
    db.connect

    val bean00: KrObjectDependenciesBean    = new KrObjectDependenciesBean
    bean00.dependentGrpCdAttr.value     = "00"

    dao.delete(db.conn, bean00)
    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]
  }
}
