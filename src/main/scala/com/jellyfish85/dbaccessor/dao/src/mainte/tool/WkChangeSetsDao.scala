package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql._
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.WkChangeSetsBean

import java.math.BigDecimal
import org.apache.commons.io.FilenameUtils
import java.text.SimpleDateFormat

/**
 * == WkChangeSetsDao ==
 *
 */
class WkChangeSetsDao extends GeneralDao[WkChangeSetsBean] {
  /**
   * == find ==
   *
   * it searches WK_CHANGE_SETS by primary keys, and returns list of WkChangeSetsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean WkChangeSetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of WK_CHANGE_SETS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: WkChangeSetsBean): List[WkChangeSetsBean] = {
    var list: List[WkChangeSetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: WkChangeSetsBean = new WkChangeSetsBean

      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.committerAttr.value = result.getString("COMMITTER")
      bean.commentsAttr.value = result.getString("COMMENTS")
      bean.actionAttr.value = result.getString("ACTION")
      bean.pathAttr.value = result.getString("PATH")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.commitDateAttr.value = result.getString("COMMIT_DATE")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findByRevision ==
   *
   * it searches WK_CHANGE_SETS by primary keys, and returns list of WkChangeSetsBean
   *
   *
   * @param conn JDBC Connection(MySQL)
   * @param revision
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of WK_CHANGE_SETS
   */
  @throws(classOf[SQLException])
  def findByRevision(conn: Connection,   revision: BigDecimal): List[WkChangeSetsBean] = {
    val formatYmd: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val formatHms: SimpleDateFormat = new SimpleDateFormat("HHmmss")

    var list: List[WkChangeSetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS_BY_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, revision)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: WkChangeSetsBean = new WkChangeSetsBean

      bean.revisionAttr.value   = result.getBigDecimal("REVISION")
      bean.committerAttr.value  = result.getString("COMMITTER")
      bean.commentsAttr.value   = result.getString("COMMENTS")
      bean.actionAttr.value     = result.getString("ACTION")
      bean.pathAttr.value       = result.getString("PATH")
      bean.fileNameAttr.value   = FilenameUtils.getName(bean.pathAttr.value)

      val commitDate: Timestamp = result.getTimestamp("COMMIT_DATE")
      bean.commitDateAttr.value = formatYmd.format(commitDate)
      bean.commitHmsAttr.value  = formatHms.format(commitDate)

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findMaxRevision ==
   *
   * it searches WK_CHANGE_SETS by primary keys, and returns list of WkChangeSetsBean
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of WK_CHANGE_SETS
   */
  @throws(classOf[SQLException])
  def findMaxRevision(conn: Connection): BigDecimal = {
    var revision: BigDecimal = new BigDecimal(0)

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_WK_CHANGE_SETS_4_MAX_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      revision = result.getBigDecimal("REVISION")
    }
    stmt.close()

    revision
  }

  /**
   * == insert ==
   *
   * it inserts to WK_CHANGE_SETS using list of WkChangeSetsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of WkChangeSetsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[WkChangeSetsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: WkChangeSetsBean =>
      stmt.setBigDecimal(1, bean.revisionAttr.value)
      stmt.setString(2, bean.committerAttr.value)
      stmt.setString(3, bean.commentsAttr.value)
      stmt.setString(4, bean.actionAttr.value)
      stmt.setString(5, bean.pathAttr.value)
      stmt.setString(6, bean.fileNameAttr.value)
      stmt.setString(7, bean.commitDateAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates WK_CHANGE_SETS using list of WkChangeSetsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of WkChangeSetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[WkChangeSetsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: WkChangeSetsBean =>
        stmt.setBigDecimal(1, bean.revisionAttr.value)
        stmt.setString(2, bean.committerAttr.value)
        stmt.setString(3, bean.commentsAttr.value)
        stmt.setString(4, bean.actionAttr.value)
        stmt.setString(5, bean.pathAttr.value)
        stmt.setString(6, bean.fileNameAttr.value)
        stmt.setString(7, bean.commitDateAttr.value)
        stmt.setString(8, bean.commitHmsAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes WK_CHANGE_SETS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean WkChangeSetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: WkChangeSetsBean): Int = {
    val result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.executeQuery()
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes WK_CHANGE_SETS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def truncate(conn: Connection): Int = {
    val result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/TRUNCATE_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.executeQuery()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to WK_CHANGE_SETS using a WkChangeSetsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean WkChangeSetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: WkChangeSetsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_WK_CHANGE_SETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}