package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrIndColumnsBean

/**
 * == RrIndColumnsDao ==
 *
 */
class RrIndColumnsDao extends GeneralDao[RrIndColumnsBean] {
  /**
   * == find ==
   *
   * it searches RR_IND_COLUMNS by primary keys, and returns list of RrIndColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RrIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_IND_COLUMNS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrIndColumnsBean): List[RrIndColumnsBean] = {
    var list: List[RrIndColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/TODO/SELECT_RR_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrIndColumnsBean = new RrIndColumnsBean

      bean.indexNameAttr.value = result.getString("INDEX_NAME")
      bean.revisionAfAttr.value = result.getBigDecimal("REVISION_AF")
      bean.revisionBfAttr.value = result.getBigDecimal("REVISION_BF")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.columnNameAttr.value = result.getString("COLUMN_NAME")
      bean.columnPositionAttr.value = result.getBigDecimal("COLUMN_POSITION")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RR_IND_COLUMNS using list of RrIndColumnsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RrIndColumnsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrIndColumnsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/INSERT_RR_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrIndColumnsBean =>
      stmt.setString(1, bean.indexNameAttr.value)
      stmt.setBigDecimal(2, bean.revisionAfAttr.value)
      stmt.setBigDecimal(3, bean.revisionBfAttr.value)
      stmt.setBigDecimal(4, bean.tableIdAttr.value)
      stmt.setBigDecimal(5, bean.columnIdAttr.value)
      stmt.setString(6, bean.columnNameAttr.value)
      stmt.setBigDecimal(7, bean.columnPositionAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * it updates RR_IND_COLUMNS using list of RrIndColumnsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RrIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrIndColumnsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/UPDATE_RR_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrIndColumnsBean =>
        stmt.setString(1, bean.indexNameAttr.value)
        stmt.setBigDecimal(2, bean.revisionAfAttr.value)
        stmt.setBigDecimal(3, bean.revisionBfAttr.value)
        stmt.setBigDecimal(4, bean.tableIdAttr.value)
        stmt.setBigDecimal(5, bean.columnIdAttr.value)
        stmt.setString(6, bean.columnNameAttr.value)
        stmt.setBigDecimal(7, bean.columnPositionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RR_IND_COLUMNS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RrIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrIndColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/DELETE_RR_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RR_IND_COLUMNS using a RrIndColumnsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RrIndColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrIndColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/MERGE_RR_IND_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}