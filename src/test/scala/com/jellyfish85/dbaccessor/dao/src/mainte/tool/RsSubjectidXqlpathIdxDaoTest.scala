package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSubjectidXqlpathIdxBean

/**
 * == RsSubjectidXqlpathIdxDaoTest ==
 *
 *
 * @author wada shunsuke
 * @since  2013/11/25
 *
 */
class RsSubjectidXqlpathIdxDaoTest extends Specification {
  val db  = new DatabaseManager
  val dao = new RsSubjectidXqlpathIdxDao

  "return true" should {
    db.connect

    val bean00: RsSubjectidXqlpathIdxBean  = new RsSubjectidXqlpathIdxBean
    bean00.pathAttr.value             = "sample/sample.java"
    bean00.subjectIdAttr.value        = "my.subjectId"
    bean00.fileNameAttr.value         = "sample.java"
    bean00.updateFlgAttr.value        = "0"
    bean00.newFlgAttr.value           = "0"

    //delete
    dao.deleteAll(db.conn)

    val list01: List[RsSubjectidXqlpathIdxBean] = dao.find(db.conn, bean00)
    "return 0 for delete table RS_SUBJECTID_BLPATH_IDX" in {
      list01.size must beEqualTo(0)
    }

    //insert
    dao.insert(db.conn, List(bean00))
    db.jCommit

    val bean01: RsSubjectidXqlpathIdxBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SUBJECTID_BLPATH_IDX" in {
      bean01.pathAttr.value               must beEqualTo("sample/sample.java")
      bean01.subjectIdAttr.value          must beEqualTo("my.subjectId")
      bean01.fileNameAttr.value           must beEqualTo("sample.java")
    }


    val bean02: RsSubjectidXqlpathIdxBean  = new RsSubjectidXqlpathIdxBean
    bean02.pathAttr.value             = "sample/sample.java"
    bean02.subjectIdAttr.value        = "my.subjectId"
    bean02.fileNameAttr.value         = "hoge.java"
    bean02.updateFlgAttr.value        = "0"
    bean02.newFlgAttr.value           = "0"

    //update
    dao.update(db.conn, List(bean02))
    db.jCommit

    val bean03: RsSubjectidXqlpathIdxBean = dao.find(db.conn, bean00).head
    "return true for insert one record to RS_SUBJECTID_BLPATH_IDX" in {
      bean03.pathAttr.value               must beEqualTo("sample/sample.java")
      bean03.subjectIdAttr.value          must beEqualTo("my.subjectId")
      bean03.fileNameAttr.value           must beEqualTo("hoge.java")
    }

  }

  "return SQLException for RS_SUBJECTID_BLPATH_IDX.SUBJECTID IS NULL" should {
    db.connect

    val bean00: RsSubjectidXqlpathIdxBean  = new RsSubjectidXqlpathIdxBean
    bean00.pathAttr.value             = "sample/sample.java"
    bean00.fileNameAttr.value         = "sample.java"
    bean00.updateFlgAttr.value        = "0"
    bean00.newFlgAttr.value           = "0"

    (dao.insert(db.conn, List(bean00))) must throwA[SQLException]


    val bean01: RsSubjectidXqlpathIdxBean  = new RsSubjectidXqlpathIdxBean
    bean01.pathAttr.value             = "sample/sample.java"
    bean01.subjectIdAttr.value        = "my.subjectId"
    bean01.fileNameAttr.value         = "hoge.java"
    bean01.updateFlgAttr.value        = "0"
    bean01.newFlgAttr.value           = "0"

    val bean02: RsSubjectidXqlpathIdxBean  = new RsSubjectidXqlpathIdxBean
    bean02.pathAttr.value             = "sample/sample.java"
    bean02.subjectIdAttr.value        = "my.subjectId"
    bean02.fileNameAttr.value         = "hoge.java"
    bean02.updateFlgAttr.value        = "0"
    bean02.newFlgAttr.value           = "0"

    (dao.insert(db.conn, List(bean01, bean02))) must throwA[SQLException]
  }

}
