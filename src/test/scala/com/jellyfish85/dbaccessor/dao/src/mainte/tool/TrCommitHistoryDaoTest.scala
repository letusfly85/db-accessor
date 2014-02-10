package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import java.math.BigDecimal

import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import java.io.{FileInputStream, File}
import org.dbunit.operation.DatabaseOperation
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.TrCommitHistoryBean

class TrCommitHistoryDaoTest extends Specification {

  val db                      = new DatabaseManager
  val dao: TrCommitHistoryDao = new TrCommitHistoryDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/src/mainte/tool/TR_COMMIT_HISTORY.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    val bean01: TrCommitHistoryBean = new TrCommitHistoryBean
    bean01.repositoryKindAttr.setValue("git")
    bean01.repositoryNameAttr.setValue("my.repository")
    bean01.rootUrlAttr.setValue("http:://my.url")
    bean01.rightBaseUrlAttr.setValue("/my/trunk/src")
    bean01.leftBaseUrlAttr.setValue("/my/branches/b01/src")
    bean01.pathAttr.setValue("my.path")

    val bean11: TrCommitHistoryBean = dao.find(db.conn, bean01).head
    "return true for TR_COMMIT_HISTORY" in {
      bean11.revisionAttr.value must beEqualTo(new BigDecimal(1))
    }

    bean01.repositoryKindAttr.setValue("subversion")
    dao.update(db.conn, List(bean01))
    db.jCommit

    val bean12: TrCommitHistoryBean = dao.find(db.conn, bean01).head
    "return true for TR_COMMIT_HISTORY" in {
      bean12.repositoryKindAttr.value must beEqualTo("subversion")
    }
  }
}
