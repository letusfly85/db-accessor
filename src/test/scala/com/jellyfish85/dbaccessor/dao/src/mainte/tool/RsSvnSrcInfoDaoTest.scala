package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager

import java.math.BigDecimal
import java.sql.SQLException
import com.jellyfish85.dbaccessor.src.mainte.tool.RsSvnSrcInfoBean

class RsSvnSrcInfoDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new RsSvnSrcInfoDao

  "return true" should {
    db.connect

    val bean00: RsSvnSrcInfoBean  = new RsSvnSrcInfoBean
    bean00.pathAttr.value         = "sample/sample.java"
    bean00.fileNameAttr.value     = "sample.java"
    bean00.projectNameAttr.value  = "com.jellyfish85"
    bean00.headRevisionAttr.value = new BigDecimal(0)

    dao.deleteAll(db.conn, bean00)
    val list: List[RsSvnSrcInfoBean] = dao.find(db.conn, bean00)
    db.jCommit

    "return 0 for insert one record to RS_SVN_SRC_INFO" in {
      list.size must beEqualTo(0)
    }
    //dao.insert(db.conn, List(bean00))
  }
}
