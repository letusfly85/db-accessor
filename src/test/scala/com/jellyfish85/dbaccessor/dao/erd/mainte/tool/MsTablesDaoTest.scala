package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsTablesBean

import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import java.io.{FileInputStream, File}
import org.dbunit.operation.DatabaseOperation

class MsTablesDaoTest extends Specification {

  val db = new DatabaseManager
  val dao: MsTablesDao = new MsTablesDao

  "return true" should {
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
    db.jCommit
    dao.insert(db.conn, list)
    db.jCommit

    val _bean: MsTablesBean  = new MsTablesBean
    _bean.physicalTableNameAttr.value =  "my.table"

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

    "return 3 for inserted list" in {
      list02.size must beEqualTo(3)
    }

    val bean04: MsTablesBean = new MsTablesBean

    bean04.physicalTableNameAttr.value = "my.table"
    bean04.logicalTableNameAttr.value  = "my.table"
    bean04.tableIdAttr.value  = new java.math.BigDecimal(1)
    bean04.revisionAttr.value = new java.math.BigDecimal(1)
    bean04.trkmIdAttr.value   = new BigDecimal(1)
    bean04.tabDefIdAttr.value = new BigDecimal(1)
    bean04.serviceNameAttr.value = "my.service"
    bean04.subsystemNameAttr.value = "my.subsystem.name"

    dao.update(db.conn, List(bean04))
    db.jCommit

    val bean05: MsTablesBean = dao.find(db.conn, bean04).head
    "return true for my.table" in {
      bean05.physicalTableNameAttr.value must beEqualTo("my.table")
      bean05.serviceNameAttr.value  must beEqualTo("my.service")
    }


    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/erd/mainte/tool/MS_TABLES_01.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    val list01: List[MsTablesBean] = dao.findByTrkmIdRange(db.conn, new BigDecimal(2831), new BigDecimal(2841))
    val ticketNumbers: List[BigDecimal] =
      List(33367,33391,33437,33468,33470,33522,33544,33551,33557,33574).map(x => new BigDecimal(x))

    val _ticketNumbers: List[BigDecimal] = list01.map(x => x.ticketNumberAttr.value)

    "return true for" in {
      _ticketNumbers must haveTheSameElementsAs(ticketNumbers)
    }
  }
}