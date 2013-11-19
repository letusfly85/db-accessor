package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSubjectidBlpathIdxBean

/**
 * == RsSubjectidBlpathIdxDao ==
 *
 */
class RsSubjectidBlpathIdxDao extends GeneralDao[RsSubjectidBlpathIdxBean] {
  /**
   * == find ==
   *
   * it searches RS_SUBJECTID_BLPATH_IDX by primary keys, and returns list of RsSubjectidBlpathIdxBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSubjectidBlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SUBJECTID_BLPATH_IDX
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsSubjectidBlpathIdxBean): List[RsSubjectidBlpathIdxBean] = {
    var list: List[RsSubjectidBlpathIdxBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SUBJECTID_BLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setString(2, bean.subjectIdAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSubjectidBlpathIdxBean = new RsSubjectidBlpathIdxBean

      bean.subjectGroupIdAttr.value = result.getString("SUBJECT_GROUP_ID")
      bean.subjectIdAttr.value = result.getString("SUBJECT_ID")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.updateFlgAttr.value = result.getString("UPDATE_FLG")
      bean.newFlgAttr.value = result.getString("NEW_FLG")
      bean.fileNameAttr.value = result.getString("FILE_NAME")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RS_SUBJECTID_BLPATH_IDX using list of RsSubjectidBlpathIdxBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSubjectidBlpathIdxBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsSubjectidBlpathIdxBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_SUBJECTID_BLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSubjectidBlpathIdxBean =>
      stmt.setString(1, bean.subjectGroupIdAttr.value)
      stmt.setString(2, bean.subjectIdAttr.value)
      stmt.setString(3, bean.pathAttr.value)
      stmt.setBigDecimal(4, bean.revisionAttr.value)
      stmt.setString(5, bean.updateFlgAttr.value)
      stmt.setString(6, bean.newFlgAttr.value)
      stmt.setString(7, bean.fileNameAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates RS_SUBJECTID_BLPATH_IDX using list of RsSubjectidBlpathIdxBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSubjectidBlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsSubjectidBlpathIdxBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_SUBJECTID_BLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSubjectidBlpathIdxBean =>
      stmt.setString(1, bean.subjectGroupIdAttr.value)
      stmt.setString(2, bean.subjectIdAttr.value)
      stmt.setString(3, bean.pathAttr.value)
      stmt.setBigDecimal(4, bean.revisionAttr.value)
      stmt.setString(5, bean.updateFlgAttr.value)
      stmt.setString(6, bean.newFlgAttr.value)
      stmt.setString(7, bean.fileNameAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SUBJECTID_BLPATH_IDX by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsSubjectidBlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsSubjectidBlpathIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SUBJECTID_BLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setString(2, bean.subjectIdAttr.value)
    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_SUBJECTID_BLPATH_IDX using a RsSubjectidBlpathIdxBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsSubjectidBlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSubjectidBlpathIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_SUBJECTID_BLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}