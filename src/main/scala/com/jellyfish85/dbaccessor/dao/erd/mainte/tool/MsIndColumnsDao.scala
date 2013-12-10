package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.{MsIndexesBean, MsIndColumnsBean}

/**
 *
 *
 */
class MsIndColumnsDao extends GeneralDao[MsIndColumnsBean] {
  /**
   *
   * @param conn JDBC Connection
   * @param bean MsIndexesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_IND_COLUMNS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: MsIndexesBean): List[MsIndColumnsBean] = {
    var list: List[MsIndColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.indexNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: MsIndColumnsBean = new MsIndColumnsBean

      bean.indexNameAttr.value = result.getString("INDEX_NAME")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.columnNameAttr.value = result.getString("COLUMN_NAME")
      bean.columnPositionAttr.value = result.getBigDecimal("COLUMN_POSITION")

      list ::= bean
    }

    list
  }


  /**
   *
   * @param conn JDBC Connection
   * @param bean MsIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_IND_COLUMNS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: MsIndColumnsBean): List[MsIndColumnsBean] = {
    var list: List[MsIndColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.indexNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: MsIndColumnsBean = new MsIndColumnsBean

      bean.indexNameAttr.value = result.getString("INDEX_NAME")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.columnNameAttr.value = result.getString("COLUMN_NAME")
      bean.columnPositionAttr.value = result.getBigDecimal("COLUMN_POSITION")
      
      list ::= bean
    }

    list
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of MsIndColumnsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[MsIndColumnsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsIndColumnsBean =>
      stmt.setString(1, bean.indexNameAttr.value)
      stmt.setBigDecimal(2, bean.revisionAttr.value)
      stmt.setBigDecimal(3, bean.tableIdAttr.value)
      stmt.setBigDecimal(4, bean.columnIdAttr.value)
      stmt.setString(5, bean.columnNameAttr.value)
      stmt.setBigDecimal(6, bean.columnPositionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of MsIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[MsIndColumnsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsIndColumnsBean =>
      stmt.setString(1, bean.indexNameAttr.value)
      stmt.setBigDecimal(2, bean.revisionAttr.value)
      stmt.setBigDecimal(3, bean.tableIdAttr.value)
      stmt.setBigDecimal(4, bean.columnIdAttr.value)
      stmt.setString(5, bean.columnNameAttr.value)
      stmt.setBigDecimal(6, bean.columnPositionAttr.value)

      stmt.setString(7, bean.indexNameAttr.value)
      stmt.setBigDecimal(8, bean.columnPositionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param bean MsIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: MsIndColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.indexNameAttr.value)
    result = stmt.executeUpdate()

    result
  }

  /**
   *
   * @param  conn JDBC Connection
   * @param  bean MsIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   *
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: MsIndColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

}