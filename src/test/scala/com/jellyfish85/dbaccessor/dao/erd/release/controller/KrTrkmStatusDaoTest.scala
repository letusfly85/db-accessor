package com.jellyfish85.dbaccessor.dao.erd.release.controller

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager

import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import java.io.{FileInputStream, File}
import org.dbunit.operation.DatabaseOperation
import com.jellyfish85.dbaccessor.bean.erd.release.controller.KrTrkmStatusBean


class KrTrkmStatusDaoTest extends Specification {

  val db: DatabaseManager  = new DatabaseManager
  val dao: KrTrkmStatusDao = new KrTrkmStatusDao
  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/erd/release/controller/KR_TRKM_STATUS.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)

    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)

    val bean00: KrTrkmStatusBean = new KrTrkmStatusBean
    bean00.trkmIdAttr.setValue(new BigDecimal(2841))

    val bean10: KrTrkmStatusBean = dao.find(db.conn, bean00).head
    "return trkm status:2 for KR_TRKM_STATUS" in {
      bean10.trkmStatusAttr.value must beEqualTo("2")
    }

    val bean11: KrTrkmStatusBean = dao.findCurrent(db.conn)
    "return trkm id:2842 for KR_TRKM_STATUS" in {
      bean11.trkmIdAttr.value must beEqualTo(new BigDecimal(2842))
    }

    val bean01: KrTrkmStatusBean = new KrTrkmStatusBean
    bean01.trkmIdAttr.setValue(new BigDecimal(2841))
    bean01.trkmStatusAttr.setValue("9")

    dao.update(db.conn, List(bean01))
    db.jCommit

    val bean12: KrTrkmStatusBean = dao.find(db.conn, bean01).head
    "return trkm status:9 for KR_TRKM_STATUS" in {
      bean12.trkmStatusAttr.value must beEqualTo("9")
    }

  }

  "return SQLException for not unique record to TP_TICKET_NUMBERS4RELEASE" should {
    db.connect

    val bean00: KrTrkmStatusBean = new KrTrkmStatusBean
    bean00.trkmIdAttr.setValue(new BigDecimal(0))

    val bean01: KrTrkmStatusBean = new KrTrkmStatusBean
    bean01.trkmIdAttr.setValue(new BigDecimal(0))

    (dao.insert(db.conn, List(bean00, bean01))) must throwA[SQLException]
  }
}
