package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSubjectidXqlpathIdxBean

/**
 * == RsSubjectidXqlpathIdxDao ==
 *
 */
class RsSubjectidXqlpathIdxDao extends GeneralDao[RsSubjectidXqlpathIdxBean] {
  /**
   * == find ==
   *
   * it searches RS_SUBJECTID_XQLPATH_IDX by primary keys, and returns list of RsSubjectidXqlpathIdxBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSubjectidXqlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SUBJECTID_XQLPATH_IDX
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsSubjectidXqlpathIdxBean): List[RsSubjectidXqlpathIdxBean] = {
    var list: List[RsSubjectidXqlpathIdxBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SUBJECTID_XQLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setString(2, bean.subjectIdAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSubjectidXqlpathIdxBean = new RsSubjectidXqlpathIdxBean

      bean.subjectIdAttr.value = result.getString("SUBJECT_ID")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.commiterAttr.value = result.getString("COMMITER")
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
   * it inserts to RS_SUBJECTID_XQLPATH_IDX using list of RsSubjectidXqlpathIdxBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSubjectidXqlpathIdxBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsSubjectidXqlpathIdxBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_SUBJECTID_XQLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSubjectidXqlpathIdxBean =>
      stmt.setString(1, bean.subjectIdAttr.value)
      stmt.setString(2, bean.pathAttr.value)
      stmt.setBigDecimal(3, bean.revisionAttr.value)
      stmt.setString(4, bean.commiterAttr.value)
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
   * it updates RS_SUBJECTID_XQLPATH_IDX using list of RsSubjectidXqlpathIdxBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSubjectidXqlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsSubjectidXqlpathIdxBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_SUBJECTID_XQLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSubjectidXqlpathIdxBean =>
      stmt.setString(1, bean.subjectIdAttr.value)
      stmt.setString(2, bean.pathAttr.value)
      stmt.setBigDecimal(3, bean.revisionAttr.value)
      stmt.setString(4, bean.commiterAttr.value)
      stmt.setString(5, bean.updateFlgAttr.value)
      stmt.setString(6, bean.newFlgAttr.value)
      stmt.setString(7, bean.fileNameAttr.value)

      stmt.setString(8, bean.pathAttr.value)
      stmt.setString(9, bean.subjectIdAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SUBJECTID_XQLPATH_IDX by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsSubjectidXqlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsSubjectidXqlpathIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SUBJECTID_XQLPATH_IDX.sql")
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
   * it merge to RS_SUBJECTID_XQLPATH_IDX using a RsSubjectidXqlpathIdxBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsSubjectidXqlpathIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSubjectidXqlpathIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_SUBJECTID_XQLPATH_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}