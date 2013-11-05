package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsPageActionIdxBean

/**
 * == RsPageActionIdxDao ==
 *
 */
class RsPageActionIdxDao extends GeneralDao[RsPageActionIdxBean] {
  /**
   * == find ==
   *
   * it searches RS_PAGE_ACTION_IDX by primary keys, and returns list of RsPageActionIdxBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsPageActionIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_PAGE_ACTION_IDX
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsPageActionIdxBean): List[RsPageActionIdxBean] = {
    var list: List[RsPageActionIdxBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_PAGE_ACTION_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsPageActionIdxBean = new RsPageActionIdxBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.pageNameAttr.value = result.getString("PAGE_NAME")
      bean.actionNameAttr.value = result.getString("ACTION_NAME")
      bean.extensionAttr.value = result.getString("EXTENSION")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RS_PAGE_ACTION_IDX using list of RsPageActionIdxBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsPageActionIdxBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsPageActionIdxBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_PAGE_ACTION_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsPageActionIdxBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.authorAttr.value)
      stmt.setString(7, bean.commitYmdAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)
      stmt.setString(9, bean.pageNameAttr.value)
      stmt.setString(10, bean.actionNameAttr.value)
      stmt.setString(11, bean.extensionAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * it updates RS_PAGE_ACTION_IDX using list of RsPageActionIdxBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsPageActionIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsPageActionIdxBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_PAGE_ACTION_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsPageActionIdxBean =>
        stmt.setBigDecimal(1, bean.headRevisionAttr.value)
        stmt.setString(2, bean.projectNameAttr.value)
        stmt.setString(3, bean.fileNameAttr.value)
        stmt.setString(4, bean.pathAttr.value)
        stmt.setBigDecimal(5, bean.revisionAttr.value)
        stmt.setString(6, bean.authorAttr.value)
        stmt.setString(7, bean.commitYmdAttr.value)
        stmt.setString(8, bean.commitHmsAttr.value)
        stmt.setString(9, bean.pageNameAttr.value)
        stmt.setString(10, bean.actionNameAttr.value)
        stmt.setString(11, bean.extensionAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_PAGE_ACTION_IDX by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsPageActionIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsPageActionIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_PAGE_ACTION_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_PAGE_ACTION_IDX using a RsPageActionIdxBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsPageActionIdxBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsPageActionIdxBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_PAGE_ACTION_IDX.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}