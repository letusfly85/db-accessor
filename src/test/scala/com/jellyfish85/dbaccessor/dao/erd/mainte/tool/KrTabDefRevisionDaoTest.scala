package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.KrTabDefRevisionBean

import java.math.BigDecimal
import java.sql.{BatchUpdateException, SQLException}

import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import java.io.{FileInputStream, File}
import org.dbunit.operation.DatabaseOperation

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

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/erd/mainte/tool/KR_TAB_DEF_REVISION_01.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

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
    "return true for TABLE_DEFINE_X.xls" in {
      bean02.svnPathAttr.value          must beEqualTo("path2")
    }

    bean00.svnPathAttr.value = "path3"
    val result02: Int = dao.merge(db.conn, bean00)
    db.jCommit

    "return 1 for updagte one record to KR_TAB_DEF_REVISION" in {
      result02 must beEqualTo(1)
    }

    val bean03: KrTabDefRevisionBean = dao.find(db.conn, bean00).head
    "return true for TABLE_DEFINE_X.xls" in {
      bean03.svnPathAttr.value          must beEqualTo("path3")
    }

    val tableDefineNames: List[String] = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
    val list01: List[KrTabDefRevisionBean] = dao.findByTableDefineNames(db.conn, tableDefineNames)

    var result: List[BigDecimal] = List()
    list01.reverse.foreach(x => result ::= x.tabDefRevisionAttr.value)

    val tabDefRevisions: List[BigDecimal] =
      List(22387,5537,11602,20124,2365,21987,20120,20118,24825,1485).map(x => new BigDecimal(x))

    "return true for findByTableDefineNames" in {
      result must haveTheSameElementsAs(tabDefRevisions)
    }
  }

  //exception
  "return error for KR_TAB_DEF_REVISION.TAB_DEF_NAME IS NULL" should {
    db.connect

    /**
     * TAB_DEF_ID		    NOT NULL,
     * TAB_DEF_REVISION	NOT NULL
     *
     */
    val bean00: KrTabDefRevisionBean = new KrTabDefRevisionBean
    bean00.tabDefIdAttr.value         = new BigDecimal(1)
    bean00.svnRevisionAttr.value      = new BigDecimal(1)
    bean00.tabDefRevisionAttr.value   = new BigDecimal(1)
    bean00.svnPathAttr.value          = "path"
    bean00.lastUpdateYmdAttr.value    = "20130827"
    bean00.lastUpdateHhmissAttr.value = "220000"

    dao.delete(db.conn, bean00)
    db.jCommit
    dao.insert(db.conn, List(bean00))
    db.jCommit
    (dao.insert(db.conn, List(bean00))) must throwA[BatchUpdateException]
  }
}