package com.jellyfish85.dbaccessor.dao.query.generate.tool

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
import com.jellyfish85.dbaccessor.bean.query.generate.tool.KrReleaseDiffsBean


class KrReleaseDiffsDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new KrReleaseDiffsDao

  "return true" should {
    db.connect

    val iConn: IDatabaseConnection  = new DatabaseConnection(db.conn, dao.getSchemaName(db.conn))
    val url: String = "/excel/query/generate/tool/KR_RELEASE_DIFFS.xls"
    val file: File  = new File(getClass().getResource(url).toURI())
    val inputStream: FileInputStream = new FileInputStream(file)
    val partialDataSet: IDataSet = new XlsDataSet(inputStream)

    DatabaseOperation.CLEAN_INSERT.execute(iConn, partialDataSet)
    db.jCommit

    val bean00: KrReleaseDiffsBean = new KrReleaseDiffsBean
    bean00.tagNameAttr.setValue("mybranch")

    val bean10: KrReleaseDiffsBean = dao.find(db.conn, bean00).head
    "return TO_REVISION:137441 for KR_RELEASE_DIFFS" in {
      bean10.toRevisionAttr.value must beEqualTo(new BigDecimal(137702))
    }

    val bean01: KrReleaseDiffsBean = new KrReleaseDiffsBean
    bean01.tagNameAttr.setValue("mybranch")
    bean01.headerFlgAttr.setValue("0")
    bean01.toRevisionAttr.setValue(bean10.toRevisionAttr.value)
    bean01.fromRevisionAttr.setValue(bean10.fromRevisionAttr.value)
    bean01.targetEnvNameAttr.setValue(bean10.targetEnvNameAttr.value)

    dao.update(db.conn, List(bean01))
    db.jCommit

    val bean12: KrReleaseDiffsBean = dao.findByToRevision(db.conn, bean01).head
    "return HEADER_FLG:0 for KR_RELEASE_DIFFS" in {
      bean12.headerFlgAttr.value must beEqualTo("0")
    }

    val bean02: KrReleaseDiffsBean = new KrReleaseDiffsBean
    bean02.tagNameAttr.setValue("mybranch")
    bean02.headerFlgAttr.setValue("1")
    bean02.toRevisionAttr.setValue(new BigDecimal(137703))
    bean02.fromRevisionAttr.setValue(bean12.toRevisionAttr.value)
    bean02.targetEnvNameAttr.setValue(bean12.targetEnvNameAttr.value)

    dao.insert(db.conn, List(bean02))
    db.jCommit

    val bean14: KrReleaseDiffsBean = dao.findByToRevision(db.conn, bean02).head
    "return HEADER_FLG:0 for KR_RELEASE_DIFFS" in {
      bean14.headerFlgAttr.value must beEqualTo("1")
      bean14.toRevisionAttr.value must beEqualTo(new BigDecimal(137703))
      bean14.fromRevisionAttr.value must beEqualTo(new BigDecimal(137702))
    }
  }

  "return SQLException for not unique record to KR_RELEASE_DIFFS" should {
    db.connect

    val bean00: KrReleaseDiffsBean = new KrReleaseDiffsBean
    bean00.tagNameAttr.setValue("mybranch")
    bean00.toRevisionAttr.setValue(new BigDecimal(1))

    val bean01: KrReleaseDiffsBean = new KrReleaseDiffsBean
    bean01.tagNameAttr.setValue("mybranch")
    bean01.toRevisionAttr.setValue(new BigDecimal(1))

    (dao.insert(db.conn, List(bean00, bean01))) must throwA[SQLException]
  }

}
