package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import java.math.BigDecimal

import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.excel.XlsDataSet
import java.io.{FileInputStream, File}
import org.dbunit.operation.DatabaseOperation
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrErdReleasesBean

class RrErdReleasesDaoTest extends Specification {

  val db: DatabaseManager   = new DatabaseManager
  val dao: RrErdReleasesDao = new RrErdReleasesDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/erd/mainte/tool/RR_ERD_RELEASES_01.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    val bean00: RrErdReleasesBean = new RrErdReleasesBean
    bean00.afReleaseIdAttr.setValue(new BigDecimal(9999999999L))
    bean00.objectTypeAttr.setValue("TABLE")
    bean00.objectNameAttr.setValue("a")

    val bean10: RrErdReleasesBean = dao.find(db.conn, bean00).head
    "return Stay Mode for object name 'a'" in {
      bean10.bfReleaseIdAttr.value mustEqual(new BigDecimal(305))
      bean10.diffTypeAttr.value mustEqual("S")
    }


    val bean01: RrErdReleasesBean = new RrErdReleasesBean
    bean01.afReleaseIdAttr.setValue(new BigDecimal(9999999999L))
    bean01.bfReleaseIdAttr.setValue(new BigDecimal(305))
    bean01.objectTypeAttr.setValue("TABLE")
    bean01.objectNameAttr.setValue("a")
    bean01.objectIdAttr.setValue(new BigDecimal(0))
    bean01.diffTypeAttr.setValue("U")

    dao.update(db.conn, List(bean01))
    db.jCommit

    val bean11: RrErdReleasesBean = dao.find(db.conn, bean01).head
    "return Update Mode for object name 'a'" in {
      bean11.bfReleaseIdAttr.value mustEqual(new BigDecimal(305))
      bean11.diffTypeAttr.value mustEqual("U")
    }

    dao.delete(db.conn, bean01)
    db.jCommit

    val list10: List[RrErdReleasesBean] = dao.find(db.conn, bean01)
    "return true for object name 'a'" in {
      list10.isEmpty mustEqual(true)
    }


    val setPreReleaseId:   BigDecimal = new BigDecimal(305)
    val setCurReleaseId:   BigDecimal = new BigDecimal(306)
    val wherePreReleaseId: BigDecimal = new BigDecimal(305)
    val whereCurReleaseId: BigDecimal = new BigDecimal(9999999999L)

    dao.updateByReleaseIds(db.conn, setPreReleaseId, setCurReleaseId, wherePreReleaseId, whereCurReleaseId)
    db.jCommit

    val bean02: RrErdReleasesBean = new RrErdReleasesBean
    bean02.afReleaseIdAttr.setValue(new BigDecimal(306))
    bean02.objectTypeAttr.setValue("TABLE")
    bean02.objectNameAttr.setValue("b")


    val bean12: RrErdReleasesBean = dao.find(db.conn, bean02).head
    "return 306 ReleaseId Mode for object name 'b'" in {
      bean12.bfReleaseIdAttr.value mustEqual(new BigDecimal(305))
      bean12.afReleaseIdAttr.value mustEqual(new BigDecimal(306))
    }


    DatabaseOperation.DELETE_ALL.execute(iConn, partialDataSet)
    db.jCommit

    val url02: String = "/excel/erd/mainte/tool/RR_ERD_RELEASES_02_FROM_MS_ERD_RELEASES.xls"
    val file02: File  = new File(getClass().getResource(url02).toURI())
    val inputStream02: FileInputStream = new FileInputStream(file02)
    val partialDataSet02: IDataSet = new XlsDataSet(inputStream02)
    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet02)
    db.jCommit

    dao.insertFromCur(db.conn, (new BigDecimal(305)))
    db.jCommit

    val bean04: RrErdReleasesBean = new RrErdReleasesBean
    bean04.afReleaseIdAttr.setValue(new BigDecimal(9999999999L))
    bean04.objectTypeAttr.setValue("TABLE")
    bean04.objectNameAttr.setValue("a")
    val bean14: RrErdReleasesBean = dao.find(db.conn, bean04).head
    "return 306 ReleaseId Mode for object name 'b'" in {
      bean14.bfReleaseIdAttr.value mustEqual(new BigDecimal(305))
      bean14.afReleaseIdAttr.value mustEqual(new BigDecimal(9999999999L))
    }

  }

}