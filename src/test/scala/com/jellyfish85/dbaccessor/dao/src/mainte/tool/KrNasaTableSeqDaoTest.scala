package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import org.dbunit.database.{DatabaseConnection, IDatabaseConnection}
import java.io.{FileInputStream, File}
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import org.dbunit.operation.DatabaseOperation
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.KrNasaTableSeqBean

/**
 *
 *
 *
 */
class KrNasaTableSeqDaoTest extends Specification {
  val db                      = new DatabaseManager
  val dao: KrNasaTableSeqDao = new KrNasaTableSeqDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/src/mainte/tool/KR_NASA_TABLE_SEQ.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    val bean01: KrNasaTableSeqBean = new KrNasaTableSeqBean
    bean01.tableNameAttr.value     = "my.table.a"

    // 検索処理テスト
    val bean11: KrNasaTableSeqBean = dao.find(db.conn, bean01).head
    "return 11 for KR_NASA_TABLE_SEQ" in {
      bean11.currentIdAttr.value must beEqualTo(new BigDecimal(11))
    }

    // 登録処理テスト
    val bean12: KrNasaTableSeqBean = new KrNasaTableSeqBean
    bean12.tableNameAttr.value  = "my.table.d"
    bean12.currentIdAttr.value  = new BigDecimal(1)
    bean12.previousIdAttr.value = new BigDecimal(2)

    dao.insert(db.conn, List(bean12))
    db.jCommit

    val bean13: KrNasaTableSeqBean = dao.find(db.conn, bean12).head
    "return 1 for KR_NASA_TABLE_SEQ" in {
      bean13.currentIdAttr.value must beEqualTo(new BigDecimal(1))
    }

    // 更新処理テスト
    val bean14: KrNasaTableSeqBean = new KrNasaTableSeqBean
    bean14.tableNameAttr.value = "my.table.a"
    bean14.currentIdAttr.value = new BigDecimal(22)
    bean14.previousIdAttr.value = new BigDecimal(21)

    dao.update(db.conn, List(bean14))
    db.jCommit

    val bean15: KrNasaTableSeqBean = dao.find(db.conn, bean14).head
    "return 22 for KR_NASA_TABLE_SEQ" in {
      bean15.currentIdAttr.value must beEqualTo(new BigDecimal(22))
    }
  }
}
