package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsTablesBean

class MsTablesDaoTest extends Specification {

  "return true" should {
    val db = new DatabaseManager
    val dao: MsTablesDao = new MsTablesDao

    db.connect

    val bean01: MsTablesBean = new MsTablesBean

    bean01.physicalTableNameAttr.value = "my.table"
    bean01.logicalTableNameAttr.value = "my table"
    bean01.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean01.revisionAttr.value = new java.math.BigDecimal(1)
    bean01.trkmIdAttr.value   = new BigDecimal(1)
    bean01.tabDefIdAttr.value = new BigDecimal(1)

    val list: List[MsTablesBean] = List(bean01)
    dao.delete(db.conn, bean01)
    dao.insert(db.conn, list)

    db.jCommit
    db.jClose

    val _bean: MsTablesBean  = new MsTablesBean
    _bean.physicalTableNameAttr.value =  "my.table"

    db.connect
    val bean: MsTablesBean = dao.find(db.conn, _bean)(0)
    "return true for my.table" in {
      val _bean: MsTablesBean = new MsTablesBean
      _bean.physicalTableNameAttr.value = "my.table"
      _bean.logicalTableNameAttr.value  = "my table"

      bean.physicalTableNameAttr.value must beEqualTo(_bean.physicalTableNameAttr.value)
      bean.logicalTableNameAttr.value  must beEqualTo(_bean.logicalTableNameAttr.value)
    }

    val bean02: MsTablesBean = new MsTablesBean

    bean02.physicalTableNameAttr.value = "my.table2"
    bean02.logicalTableNameAttr.value = "my table 2"
    bean02.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean02.revisionAttr.value = new java.math.BigDecimal(1)
    bean02.trkmIdAttr.value   = new BigDecimal(1)
    bean02.tabDefIdAttr.value = new BigDecimal(1)

    val bean03: MsTablesBean = new MsTablesBean

    bean03.physicalTableNameAttr.value = "my.table3"
    bean03.logicalTableNameAttr.value = "my table 3"
    bean03.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean03.revisionAttr.value = new java.math.BigDecimal(1)
    bean03.trkmIdAttr.value   = new BigDecimal(1)
    bean03.tabDefIdAttr.value = new BigDecimal(1)

    dao.delete(db.conn, bean01)
    dao.delete(db.conn, bean02)
    dao.delete(db.conn, bean03)
    db.jCommit
    dao.insert(db.conn, List(bean01, bean02, bean03))
    db.jCommit

    val tableNames: List[String] = List(bean01.physicalTableNameAttr.value,
                                        bean02.physicalTableNameAttr.value,
                                        bean03.physicalTableNameAttr.value)

    val list02: List[MsTablesBean] = dao.findByTableNames(db.conn, tableNames)

    db.jClose
    "return true for indexNames" in {
      list02.size must beEqualTo(3)
    }
  }
}