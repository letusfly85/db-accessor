package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsPageActionIdxBean


class RsPageActionIdxDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsPageActionIdxDao

  "return true" should {
    db.connect

    val bean00: RsPageActionIdxBean  = new RsPageActionIdxBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"
    bean00.projectNameAttr.value  = "com.jellyfish85"
    bean00.headRevisionAttr.value = new BigDecimal(0)

    //delete
    dao.delete(db.conn, bean00)
    val list01: List[RsPageActionIdxBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for insert one record to RS_SVN_SRC_INFO" in {
      list01.size must beEqualTo(0)
    }
  }
}
