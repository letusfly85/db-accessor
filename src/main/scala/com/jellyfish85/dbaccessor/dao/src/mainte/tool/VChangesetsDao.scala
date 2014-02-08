package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql._
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.VChangesetsBean

import java.math.BigDecimal
import java.text.SimpleDateFormat
import org.apache.commons.io.FilenameUtils

/**
 * == VChangesetsDao ==
 *
 */
class VChangesetsDao extends GeneralDao[VChangesetsBean] {

  /**
   * == findByTicketNumber ==
   *
   * it searches V_CHANGESETS by primary keys, and returns list of VChangesetsBean
   *
   *
   * @param conn JDBC Connection
   * @param ticketNumber VChangesetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of V_CHANGESETS
   */
  @throws(classOf[SQLException])
  def findByTicketNumber(conn: Connection,  ticketNumber: BigDecimal): List[VChangesetsBean] = {
    var list: List[VChangesetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS_BY_TICKET_NUMBER.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, ticketNumber)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: VChangesetsBean = new VChangesetsBean

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
   * == findByCommitDateAndPath ==
   *
   * it searches V_CHANGESETS by primary keys, and returns list of VChangesetsBean
   *
   *
   * @param conn JDBC Connection
   * @param commitDate
   * @param path
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of V_CHANGESETS
   */
  @throws(classOf[SQLException])
  def findByCommitDateAndPath(conn: Connection,  commitDate: String, path: String): List[VChangesetsBean] = {
    var list: List[VChangesetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS_BY_COMMIT_DATE_AND_PATH.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, commitDate)
    stmt.setString(2, path)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: VChangesetsBean = new VChangesetsBean

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
   * == findByRevisionAndPath ==
   *
   * it searches V_CHANGESETS by primary keys, and returns list of VChangesetsBean
   *
   *
   * @param conn JDBC Connection
   * @param fromRevision
   * @param toRevision
   * @param path
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of V_CHANGESETS
   */
  @throws(classOf[SQLException])
  def findByRevisionAndPath(
      conn: Connection, fromRevision: BigDecimal, toRevision: BigDecimal, path: String, repositoryCd: String
                            ): List[VChangesetsBean] = {
    val formatYmd: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val formatHms: SimpleDateFormat = new SimpleDateFormat("hhmmss")

    var list: List[VChangesetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS_BY_REVISION_AND_PATH.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, fromRevision)
    stmt.setBigDecimal(2, toRevision)
    stmt.setString(3, path)
    stmt.setString(4, repositoryCd)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: VChangesetsBean = new VChangesetsBean

      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.committerAttr.value = result.getString("COMMITTER")
      bean.commentsAttr.value = result.getString("COMMENTS")
      bean.actionAttr.value = result.getString("ACTION")
      bean.pathAttr.value = result.getString("PATH")
      //bean.fileNameAttr.value = result.getString("FILE_NAME")

      val commitDate: Date      = result.getDate("COMMIT_DATE")
      bean.commitDateAttr.value = formatYmd.format(commitDate)
      bean.commitHmsAttr.value  = formatHms.format(commitDate)

      list ::= bean
    }
    stmt.close()

    list
  }

  //SELECT_V_CHANGESETS_UNIQUE
  /**
   * == findByRevisionAndPath ==
   *
   * it searches V_CHANGESETS by primary keys, and returns list of VChangesetsBean
   *
   *
   * @param conn JDBC Connection
   * @param revision
   * @param path
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of V_CHANGESETS
   */
  @throws(classOf[SQLException])
  def findUnique(conn: Connection, revision: BigDecimal, path: String): VChangesetsBean = {
    val formatYmd: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val formatHms: SimpleDateFormat = new SimpleDateFormat("hhmmss")

    var list: List[VChangesetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS_UNIQUE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, revision)
    stmt.setString(2, path)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: VChangesetsBean = new VChangesetsBean

      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.committerAttr.value = result.getString("COMMITTER")
      bean.commentsAttr.value = result.getString("COMMENTS")
      bean.actionAttr.value = result.getString("ACTION")
      bean.pathAttr.value = result.getString("PATH")
      bean.fileNameAttr.value = FilenameUtils.getName(bean.pathAttr.value)

      val commitDate: Date      = result.getDate("COMMIT_DATE")
      bean.commitDateAttr.value = formatYmd.format(commitDate)
      bean.commitHmsAttr.value  = formatHms.format(commitDate)

      list ::= bean
    }
    stmt.close()

    list.head
  }

  /**
   * == find ==
   *
   * it searches V_CHANGESETS by primary keys, and returns list of VChangesetsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean VChangesetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of V_CHANGESETS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: VChangesetsBean): List[VChangesetsBean] = {
    var list: List[VChangesetsBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_V_CHANGESETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: VChangesetsBean = new VChangesetsBean

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
   * == insert ==
   *
   * it inserts to V_CHANGESETS using list of VChangesetsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of VChangesetsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[VChangesetsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_V_CHANGESETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: VChangesetsBean =>
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
   * it updates V_CHANGESETS using list of VChangesetsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of VChangesetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[VChangesetsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_V_CHANGESETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: VChangesetsBean =>
      stmt.setBigDecimal(1, bean.revisionAttr.value)
      stmt.setString(2, bean.committerAttr.value)
      stmt.setString(3, bean.commentsAttr.value)
      stmt.setString(4, bean.actionAttr.value)
      stmt.setString(5, bean.pathAttr.value)
      stmt.setString(6, bean.fileNameAttr.value)
      stmt.setString(7, bean.commitDateAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)

      stmt.setString(9, bean.pathAttr.value)
      stmt.setBigDecimal(10, bean.revisionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes V_CHANGESETS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean VChangesetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: VChangesetsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_V_CHANGESETS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setBigDecimal(2, bean.revisionAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to V_CHANGESETS using a VChangesetsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean VChangesetsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: VChangesetsBean): Int = {
    val result: Int = 0

    result
  }
}