package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{Connection, SQLException, ResultSet, PreparedStatement}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsTablesBean
import java.util

import java.math.BigDecimal

class MsTablesDao extends GeneralDao[MsTablesBean] {

  /**
   * == find ==
   *
   * it searches MS_TABLES by primary keys, and returns list of MsTablesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean MsTablesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: MsTablesBean): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)
    try {
      stmt.setString(1, bean.physicalTableNameAttr.value)

      val result: ResultSet = stmt.executeQuery()

      while (result.next()) {
        val bean: MsTablesBean = new MsTablesBean()

        bean.trkmIdAttr.value             = result.getBigDecimal("TRKM_ID")
        bean.tabDefIdAttr.value           = result.getBigDecimal("TAB_DEF_ID")
        bean.tableIdAttr.value            = result.getBigDecimal("TABLE_ID")
        bean.serviceNameAttr.value        = result.getString("SERVICE_NAME")
        bean.systemNameAttr.value      = result.getString("SYSTEM_NAME")
        bean.subsystemNameAttr.value      = result.getString("SUBSYSTEM_NAME")
        bean.revisionAttr.value           = result.getBigDecimal("REVISION")
        bean.logicalTableTagAttr.value    = result.getString("LOGICAL_TABLE_TAG")
        bean.logicalTableNameAttr.value   = result.getString("LOGICAL_TABLE_NAME")
        bean.physicalTableNameAttr.value  = result.getString("PHYSICAL_TABLE_NAME")
        bean.trkmStatusAttr.value         = result.getString("TRKM_STATUS")
        bean.tableCommentAttr.value       = result.getString("TABLE_COMMENT")
        bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
        bean.ticketNumberAttr.value       = result.getBigDecimal("TICKET_NUMBER")
        bean.existsFlgAttr.value          = result.getString("EXISTS_FLG")

        list ::= bean

      }

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException

    } finally {
        stmt.close()
    }

    list
  }

  /**
   * == findByTableNames ==
   *
   * it searches MS_TABLES by primary keys, and returns list of MsTablesBean
   *
   *
   * @param conn JDBC Connection
   * @param tableNames table name list
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def findByTableNames(conn: Connection,   tableNames: List[String]): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    val map: Map[String, List[String]] = Map("tableNames" -> tableNames)
    val sql: String = generateSQLIncludesList("/query/erd/mainte/tool/SELECT_MS_TABLES_BY_TABLE_NAMES.sql", map)

    val stmt: PreparedStatement = conn.prepareStatement(sql)
    var i: Int = 1
    tableNames.foreach {v =>
      stmt.setString(i, v)
      i += 1
    }
    val result: ResultSet = stmt.executeQuery()

    while (result.next()) {
      val bean: MsTablesBean = new MsTablesBean()

      bean.trkmIdAttr.value             = result.getBigDecimal("TRKM_ID")
      bean.tabDefIdAttr.value           = result.getBigDecimal("TAB_DEF_ID")
      bean.tableIdAttr.value            = result.getBigDecimal("TABLE_ID")
      bean.serviceNameAttr.value        = result.getString("SERVICE_NAME")
      bean.systemNameAttr.value      = result.getString("SYSTEM_NAME")
      bean.subsystemNameAttr.value      = result.getString("SUBSYSTEM_NAME")
      bean.revisionAttr.value           = result.getBigDecimal("REVISION")
      bean.logicalTableTagAttr.value    = result.getString("LOGICAL_TABLE_TAG")
      bean.logicalTableNameAttr.value   = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value  = result.getString("PHYSICAL_TABLE_NAME")
      bean.trkmStatusAttr.value         = result.getString("TRKM_STATUS")
      bean.tableCommentAttr.value       = result.getString("TABLE_COMMENT")
      bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
      bean.ticketNumberAttr.value       = result.getBigDecimal("TICKET_NUMBER")
      bean.existsFlgAttr.value          = result.getString("EXISTS_FLG")

      list ::= bean

    }
    stmt.close()

    list
  }

  /**
   * == findByReleaseId ==
   *
   * it searches MS_TABLES by primary keys, and returns list of MsTablesBean
   *
   *
   * @param conn JDBC Connection
   * @param releaseId
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def findByReleaseId(conn: Connection,   releaseId: BigDecimal): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES_RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)
    stmt.setBigDecimal(1, releaseId)

    val result: ResultSet = stmt.executeQuery()

    while (result.next()) {
      val bean: MsTablesBean = new MsTablesBean()

      bean.trkmIdAttr.value             = result.getBigDecimal("TRKM_ID")
      bean.tabDefIdAttr.value           = result.getBigDecimal("TAB_DEF_ID")
      bean.tableIdAttr.value            = result.getBigDecimal("TABLE_ID")
      bean.serviceNameAttr.value        = result.getString("SERVICE_NAME")
      bean.systemNameAttr.value      = result.getString("SYSTEM_NAME")
      bean.subsystemNameAttr.value      = result.getString("SUBSYSTEM_NAME")
      bean.revisionAttr.value           = result.getBigDecimal("REVISION")
      bean.logicalTableTagAttr.value    = result.getString("LOGICAL_TABLE_TAG")
      bean.logicalTableNameAttr.value   = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value  = result.getString("PHYSICAL_TABLE_NAME")
      bean.trkmStatusAttr.value         = result.getString("TRKM_STATUS")
      bean.tableCommentAttr.value       = result.getString("TABLE_COMMENT")
      bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
      bean.ticketNumberAttr.value       = result.getBigDecimal("TICKET_NUMBER")
      bean.existsFlgAttr.value          = result.getString("EXISTS_FLG")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findByTableNames ==
   *
   * it searches MS_TABLES by primary keys, and returns list of MsTablesBean
   *
   *
   * @param conn JDBC Connection
   * @param tableNames table name list
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def findByTableNames(conn: Connection,   tableNames: util.ArrayList[String]): List[MsTablesBean] = {
    var _tableNames: List[String] = List()

    for (i <- 0 until tableNames.size()) {
      val tableName: String = tableNames.get(i)

      _tableNames ::= tableName
    }

    findByTableNames(conn, _tableNames)
  }

  /**
   * == findByTrkmIdRange ==
   *
   * it searches MS_TABLES by trkm id range, and returns list of MsTablesBean
   *
   *
   * @param conn JDBC Connection
   * @param preTrkmId
   * @param curTrkmId
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def findByTrkmIdRange(conn: Connection,   preTrkmId: BigDecimal, curTrkmId: BigDecimal): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES_BETWEEN_TRKM_ID.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)
    stmt.setBigDecimal(1, preTrkmId)
    stmt.setBigDecimal(2, curTrkmId)

    val result: ResultSet = stmt.executeQuery()

    while (result.next()) {
      val bean: MsTablesBean = new MsTablesBean()

      bean.trkmIdAttr.value             = result.getBigDecimal("TRKM_ID")
      bean.ticketNumberAttr.value       = result.getBigDecimal("TICKET_NUMBER")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * システム名称を引数にテーブル一覧を取得します。
   *
   *
   * @param conn JDBC Connection
   * @param systemName システム名称
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_TABLES
   */
  @throws(classOf[SQLException])
  def findAllBySystemName(conn: Connection, systemName: String): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES_BY_SYSTEM_NAME.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)
    stmt.setString(1, systemName)

    val result: ResultSet = stmt.executeQuery()

    while (result.next()) {
      val bean: MsTablesBean = new MsTablesBean()

      bean.physicalTableNameAttr.value  = result.getString("PHYSICAL_TABLE_NAME")
      bean.tableIdAttr.value            = result.getBigDecimal("TABLE_ID")
      bean.revisionAttr.value           = result.getBigDecimal("REVISION")

      list ::= bean
    }
    stmt.close()

    list
  }


  /**
   * == findOne ==
   *
   * @param conn
   * @param bean
   * @return
   */
  @throws(classOf[SQLException])
  def findOne(conn: Connection,   bean: MsTablesBean): MsTablesBean = {
    find(conn, bean).head
  }

  /**
   * == insert ==
   *
   * @param conn
   * @param list
   * @return
   *
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[MsTablesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsTablesBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setBigDecimal(2, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(3, bean.tableIdAttr.value)
      stmt.setString(4, bean.serviceNameAttr.value)
      stmt.setString(5, bean.subsystemNameAttr.value)
      stmt.setBigDecimal(6, bean.revisionAttr.value)
      stmt.setString(7, bean.logicalTableTagAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.physicalTableNameAttr.value)
      stmt.setString(10, bean.trkmStatusAttr.value)
      stmt.setString(11, bean.tableCommentAttr.value)
      stmt.setString(12, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(13, bean.ticketNumberAttr.value)
      stmt.setString(14, bean.existsFlgAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * @param conn
   * @param list
   * @return
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[MsTablesBean]) : Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsTablesBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setBigDecimal(2, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(3, bean.tableIdAttr.value)
      stmt.setString(4, bean.serviceNameAttr.value)
      stmt.setString(5, bean.subsystemNameAttr.value)
      stmt.setBigDecimal(6, bean.revisionAttr.value)
      stmt.setString(7, bean.logicalTableTagAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.trkmStatusAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setString(11, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(12, bean.ticketNumberAttr.value)
      stmt.setString(13, bean.existsFlgAttr.value)

      stmt.setString(14, bean.physicalTableNameAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()
    result
  }

  /**
   * == delete ==
   *
   * @param conn
   * @param bean
   * @return
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: MsTablesBean): Int = {
    var result: Int = 0

    val sql  = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_TABLES.sql")
    val stmt = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.tableIdAttr.value)
    stmt.setString(2, bean.physicalTableNameAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == table master merge ==
   *
   * @param  conn JDBC Connection
   * @param  bean MsTablesBean
   * @return result which is the number of executed records
   * @todo
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: MsTablesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.physicalTableNameAttr.value)
    stmt.setBigDecimal(2, bean.revisionAttr.value)
    stmt.setString(3, bean.logicalTableNameAttr.value)
    stmt.setString(4, bean.trkmStatusAttr.value)
    stmt.setString(5, bean.tableCommentAttr.value)
    stmt.setString(6, bean.segoseiCheckStatusAttr.value)
    stmt.setBigDecimal(7, bean.ticketNumberAttr.value)
    stmt.setBigDecimal(8, bean.trkmIdAttr.value)

    stmt.setBigDecimal(9, bean.trkmIdAttr.value)
    stmt.setBigDecimal(10, bean.tabDefIdAttr.value)
    stmt.setString(11, bean.serviceNameAttr.value)
    stmt.setString(12, bean.subsystemNameAttr.value)
    stmt.setBigDecimal(13, bean.revisionAttr.value)
    stmt.setString(14, bean.logicalTableNameAttr.value)
    stmt.setString(15, bean.physicalTableNameAttr.value)
    stmt.setString(16, bean.trkmStatusAttr.value)
    stmt.setString(17, bean.tableCommentAttr.value)
    stmt.setString(18, bean.segoseiCheckStatusAttr.value)
    stmt.setBigDecimal(19, bean.ticketNumberAttr.value)
    stmt.setString(20, bean.existsFlgAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}
