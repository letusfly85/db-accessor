package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSubjectidBlpathIdxBean

class RsSubjectidBlpathIdxDaoTest extends Specification {
  
  val db  = new DatabaseManager
  val dao = new RsSubjectidBlpathIdxDao

  "return true" should {
    db.connect

    val bean00: RsSubjectidBlpathIdxBean  = new RsSubjectidBlpathIdxBean
    bean00.pathAttr.value             = "sample/sample.java"
    bean00.subjectIdAttr.value        = "my.subjectId"
    bean00.subjectGroupIdAttr.value   = "my.subjectGroupId"
    bean00.fileNameAttr.value         = "sample.java"
    bean00.updateFlgAttr.value        = "0"
    bean00.newFlgAttr.value           = "0"

    //delete
    dao.delete(db.conn, bean00)

    val list01: List[RsSubjectidBlpathIdxBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SQL_TEXT_EXP" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSubjectidBlpathIdxBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT_EXP" in {
      bean01.pathAttr.value               must beEqualTo("sample/sample.java")
      bean01.subjectIdAttr.value          must beEqualTo("my.subjectId")
      bean01.fileNameAttr.value           must beEqualTo("sample.java")
    }


    val bean02: RsSubjectidBlpathIdxBean  = new RsSubjectidBlpathIdxBean
    bean02.pathAttr.value             = "sample/sample.java"
    bean02.subjectIdAttr.value        = "my.subjectId"
    bean02.subjectGroupIdAttr.value   = "my.subjectGroupId"
    bean02.fileNameAttr.value         = "hoge.java"
    bean02.updateFlgAttr.value        = "0"
    bean02.newFlgAttr.value           = "0"

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSubjectidBlpathIdxBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SQL_TEXT_EXP" in {
      bean03.pathAttr.value               must beEqualTo("sample/sample.java")
      bean03.subjectIdAttr.value          must beEqualTo("my.subjectId")
      bean03.fileNameAttr.value           must beEqualTo("hoge.java")
    }

  }
}
