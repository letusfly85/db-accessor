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
import com.jellyfish85.dbaccessor.bean.erd.release.controller.TpTicketNumbers4releaseBean

class TpTicketNumbers4releaseDaoTest extends Specification {

  val db:  DatabaseManager            = new DatabaseManager
  val dao: TpTicketNumbers4releaseDao = new TpTicketNumbers4releaseDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))

    val url: String = "/excel/erd/release/controller/TP_TICKET_NUMBERS4RELEASE.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)

    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)

    val bean00: TpTicketNumbers4releaseBean = new TpTicketNumbers4releaseBean
    bean00.releaseIdAttr.setValue(new BigDecimal(207))
    bean00.trkmIdAttr.setValue(new BigDecimal(2693))

    val bean10: TpTicketNumbers4releaseBean = dao.find(db.conn, bean00).head
    "return ticket number:31521 for TP_TICKET_NUMBERS4RELEASE" in {
      bean10.ticketNumberAttr.value must beEqualTo(new BigDecimal(31521))
    }


    val bean01: TpTicketNumbers4releaseBean = new TpTicketNumbers4releaseBean
    bean01.releaseIdAttr.setValue(new BigDecimal(207))
    bean01.trkmIdAttr.setValue(new BigDecimal(2693))
    bean01.ticketNumberAttr.setValue(new BigDecimal(100))

    dao.update(db.conn, List(bean01))
    db.jCommit

    val bean11: TpTicketNumbers4releaseBean = dao.find(db.conn, bean01).head
    "return ticket number:100 for TP_TICKET_NUMBERS4RELEASE" in {
      bean11.ticketNumberAttr.value must beEqualTo(new BigDecimal(100))
    }

    dao.delete(db.conn, bean01)
    db.jCommit

    val list12: List[TpTicketNumbers4releaseBean] = dao.find(db.conn, bean01)
    db.jClose
    "return empty for TP_TICKET_NUMBERS4RELEASE" in {
      list12.isEmpty must beTrue
    }
  }

  "return SQLException for not unique record to TP_TICKET_NUMBERS4RELEASE" should {
    db.connect

    val bean00: TpTicketNumbers4releaseBean = new TpTicketNumbers4releaseBean
    bean00.releaseIdAttr.setValue(new BigDecimal(0))

    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]
  }
}