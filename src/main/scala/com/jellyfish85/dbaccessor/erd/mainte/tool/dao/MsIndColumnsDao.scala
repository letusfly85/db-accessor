
package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndColumnsBean

/**
 *
 *
 */
class MsIndColumnsDao extends GeneralDao[MsIndColumnsBean] {
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

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELLECT_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

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

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

  /**
   *
   * @param  conn JDBC Connection
   * @param  bean MsIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: MsIndColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

}