package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrTabColumnsBean

/**
 * == RrTabColumnsDao ==
 *
 */
class RrTabColumnsDao extends GeneralDao[RrTabColumnsBean] {
  /**
   * == find ==
   *
   * it searches RR_TAB_COLUMNS by primary keys, and returns list of RrTabColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RrTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_TAB_COLUMNS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrTabColumnsBean): List[RrTabColumnsBean] = {
    var list: List[RrTabColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELLECT_RR_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //erd/mainte/tool stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrTabColumnsBean = new RrTabColumnsBean

      bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.revisionAfAttr.value = result.getBigDecimal("REVISION_AF")
      bean.revisionBfAttr.value = result.getBigDecimal("REVISION_BF")
      bean.authourAttr.value = result.getString("AUTHOUR")
      bean.updatorAttr.value = result.getString("UPDATOR")
      bean.logicalTableTagAttr.value = result.getString("LOGICAL_TABLE_TAG")
      bean.logicalTableNameAttr.value = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
      bean.tableCommentAttr.value = result.getString("TABLE_COMMENT")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.logicalColumnTagAttr.value = result.getString("LOGICAL_COLUMN_TAG")
      bean.logicalColumnNameAttr.value = result.getString("LOGICAL_COLUMN_NAME")
      bean.physicalColumnNameAttr.value = result.getString("PHYSICAL_COLUMN_NAME")
      bean.columnCommentAttr.value = result.getString("COLUMN_COMMENT")
      bean.dataTypeAttr.value = result.getString("DATA_TYPE")
      bean.dataLengthAttr.value = result.getString("DATA_LENGTH")
      bean.dataPrecisionAttr.value = result.getString("DATA_PRECISION")
      bean.dataDefaultAttr.value = result.getString("DATA_DEFAULT")
      bean.dataScaleAttr.value = result.getString("DATA_SCALE")
      bean.pkFlgAttr.value = result.getString("PK_FLG")
      bean.nullableAttr.value = result.getString("NULLABLE")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
      bean.segoseiCheckLogIdAttr.value = result.getBigDecimal("SEGOSEI_CHECK_LOG_ID")
      bean.ticketNumberAttr.value = result.getBigDecimal("TICKET_NUMBER")
      bean.existsFlgAttr.value = result.getString("EXISTS_FLG")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RR_TAB_COLUMNS using list of RrTabColumnsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RrTabColumnsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrTabColumnsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_RR_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTabColumnsBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(2, bean.tableIdAttr.value)
      stmt.setBigDecimal(3, bean.revisionAfAttr.value)
      stmt.setBigDecimal(4, bean.revisionBfAttr.value)
      stmt.setString(5, bean.authourAttr.value)
      stmt.setString(6, bean.updatorAttr.value)
      stmt.setString(7, bean.logicalTableTagAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.physicalTableNameAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setBigDecimal(11, bean.columnIdAttr.value)
      stmt.setString(12, bean.logicalColumnTagAttr.value)
      stmt.setString(13, bean.logicalColumnNameAttr.value)
      stmt.setString(14, bean.physicalColumnNameAttr.value)
      stmt.setString(15, bean.columnCommentAttr.value)
      stmt.setString(16, bean.dataTypeAttr.value)
      stmt.setString(17, bean.dataLengthAttr.value)
      stmt.setString(18, bean.dataPrecisionAttr.value)
      stmt.setString(19, bean.dataDefaultAttr.value)
      stmt.setString(20, bean.dataScaleAttr.value)
      stmt.setString(21, bean.pkFlgAttr.value)
      stmt.setString(22, bean.nullableAttr.value)
      stmt.setString(23, bean.trkmStatusAttr.value)
      stmt.setString(24, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(25, bean.segoseiCheckLogIdAttr.value)
      stmt.setBigDecimal(26, bean.ticketNumberAttr.value)
      stmt.setString(27, bean.existsFlgAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * it updates RR_TAB_COLUMNS using list of RrTabColumnsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RrTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrTabColumnsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_RR_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTabColumnsBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(2, bean.tableIdAttr.value)
      stmt.setBigDecimal(3, bean.revisionAfAttr.value)
      stmt.setBigDecimal(4, bean.revisionBfAttr.value)
      stmt.setString(5, bean.authourAttr.value)
      stmt.setString(6, bean.updatorAttr.value)
      stmt.setString(7, bean.logicalTableTagAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.physicalTableNameAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setBigDecimal(11, bean.columnIdAttr.value)
      stmt.setString(12, bean.logicalColumnTagAttr.value)
      stmt.setString(13, bean.logicalColumnNameAttr.value)
      stmt.setString(14, bean.physicalColumnNameAttr.value)
      stmt.setString(15, bean.columnCommentAttr.value)
      stmt.setString(16, bean.dataTypeAttr.value)
      stmt.setString(17, bean.dataLengthAttr.value)
      stmt.setString(18, bean.dataPrecisionAttr.value)
      stmt.setString(19, bean.dataDefaultAttr.value)
      stmt.setString(20, bean.dataScaleAttr.value)
      stmt.setString(21, bean.pkFlgAttr.value)
      stmt.setString(22, bean.nullableAttr.value)
      stmt.setString(23, bean.trkmStatusAttr.value)
      stmt.setString(24, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(25, bean.segoseiCheckLogIdAttr.value)
      stmt.setBigDecimal(26, bean.ticketNumberAttr.value)
      stmt.setString(27, bean.existsFlgAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RR_TAB_COLUMNS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RrTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrTabColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_RR_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //erd/mainte/tool stmt.setMethods
    stmt.setBigDecimal(1, bean.tableIdAttr.value)
    stmt.setString(2, bean.physicalTableNameAttr.value)
    stmt.setBigDecimal(3, bean.revisionAfAttr.value)

    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RR_TAB_COLUMNS using a RrTabColumnsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RrTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrTabColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_RR_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //erd/mainte/tool stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}