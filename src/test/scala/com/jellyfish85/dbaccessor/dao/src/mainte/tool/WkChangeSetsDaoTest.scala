package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import org.dbunit.database.{DatabaseConnection, IDatabaseConnection}
import java.io.{FileInputStream, File}
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import org.dbunit.operation.DatabaseOperation
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.WkChangeSetsBean

/**
 *
 *
 *
 */
class WkChangeSetsDaoTest extends Specification {
  val db                      = new DatabaseManager
  val dao: WkChangeSetsDao = new WkChangeSetsDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/src/mainte/tool/WK_CHANGE_SETS.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    dao.truncate(db.conn)
    val bean01: WkChangeSetsBean = new WkChangeSetsBean
    bean01.revisionAttr.value = new BigDecimal(0)

    val list01: List[WkChangeSetsBean] = dao.find(db.conn, bean01)
    "return empty for WK_CHANGE_SETS" in {
      list01.isEmpty must beEqualTo(true)
    }

    val bean02: WkChangeSetsBean = new WkChangeSetsBean
    bean02.revisionAttr.value = new BigDecimal(1)

    val bean03: WkChangeSetsBean = new WkChangeSetsBean
    bean03.revisionAttr.value = new BigDecimal(2)

    dao.insert(db.conn, List(bean02, bean03))
    db.jCommit

    val list02: List[WkChangeSetsBean] = dao.find(db.conn, bean01)
    "return 2 for WK_CHANGE_SETS" in {
      list02.size must beEqualTo(2)
    }
  }
}
