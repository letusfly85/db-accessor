package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrTablesBean

/**
 * == RrTablesDao ==
 *
 */
class RrTablesDao extends GeneralDao[RrTablesBean] {
  /**
   * == find ==
   *
   * @param conn JDBC Connection
   * @param bean RrTablesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_TABLES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrTablesBean): List[RrTablesBean] = {
    var list: List[RrTablesBean] = List()

    val sql:  String = generateSimpleQuery("/query/TODO/SELLECT_RR_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrTablesBean = new RrTablesBean

      bean.trkmIdAttr.value = result.getBigDecimal("TRKM_ID")
      bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.revisionAfAttr.value = result.getBigDecimal("REVISION_AF")
      bean.revisionBfAttr.value = result.getBigDecimal("REVISION_BF")
      bean.logicalTableTagAttr.value = result.getString("LOGICAL_TABLE_TAG")
      bean.logicalTableNameAttr.value = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      bean.tableCommentAttr.value = result.getString("TABLE_COMMENT")
      bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
      bean.ticketNumberAttr.value = result.getBigDecimal("TICKET_NUMBER")
      bean.existsFlgAttr.value = result.getString("EXISTS_FLG")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * @param conn JDBC Connection
   * @param list list of RrTablesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrTablesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/INSERT_RR_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTablesBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setBigDecimal(2, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(3, bean.tableIdAttr.value)
      stmt.setBigDecimal(4, bean.revisionAfAttr.value)
      stmt.setBigDecimal(5, bean.revisionBfAttr.value)
      stmt.setString(6, bean.logicalTableTagAttr.value)
      stmt.setString(7, bean.logicalTableNameAttr.value)
      stmt.setString(8, bean.physicalTableNameAttr.value)
      stmt.setString(9, bean.trkmStatusAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setString(11, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(12, bean.ticketNumberAttr.value)
      stmt.setString(13, bean.existsFlgAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * @param conn JDBC Connection
   * @param list list of RrTablesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrTablesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/UPDATE_RR_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTablesBean =>
              stmt.setBigDecimal(1, bean.trkmIdAttr.value)
              stmt.setBigDecimal(2, bean.tabDefIdAttr.value)
              stmt.setBigDecimal(3, bean.tableIdAttr.value)
              stmt.setBigDecimal(4, bean.revisionAfAttr.value)
              stmt.setBigDecimal(5, bean.revisionBfAttr.value)
              stmt.setString(6, bean.logicalTableTagAttr.value)
              stmt.setString(7, bean.logicalTableNameAttr.value)
              stmt.setString(8, bean.physicalTableNameAttr.value)
              stmt.setString(9, bean.trkmStatusAttr.value)
              stmt.setString(10, bean.tableCommentAttr.value)
              stmt.setString(11, bean.segoseiCheckStatusAttr.value)
              stmt.setBigDecimal(12, bean.ticketNumberAttr.value)
              stmt.setString(13, bean.existsFlgAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * @param conn JDBC Connection
   * @param bean RrTablesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrTablesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/DELETE_RR_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * @param  conn JDBC Connection
   * @param  bean RrTablesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrTablesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/MERGE_RR_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}