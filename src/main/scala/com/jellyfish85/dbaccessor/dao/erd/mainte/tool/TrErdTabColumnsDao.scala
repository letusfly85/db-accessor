package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.TrErdTabColumnsBean

/**
 * == TrErdTabColumnsDao ==
 *
 */
class TrErdTabColumnsDao extends GeneralDao[TrErdTabColumnsBean] {
  /**
   * == find ==
   *
   * it searches TR_ERD_TAB_COLUMNS by primary keys, and returns list of TrErdTabColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean TrErdTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_ERD_TAB_COLUMNS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: TrErdTabColumnsBean): List[TrErdTabColumnsBean] = {
    var list: List[TrErdTabColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/TODO/SELECT_TR_ERD_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: TrErdTabColumnsBean = new TrErdTabColumnsBean

      bean.trkmIdAttr.value = result.getBigDecimal("TRKM_ID")
      bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
      bean.logicalTableNameAttr.value = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
      bean.tableCommentAttr.value = result.getString("TABLE_COMMENT")
      bean.dictColumnIdAttr.value = result.getBigDecimal("DICT_COLUMN_ID")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.logicalColumnNameAttr.value = result.getString("LOGICAL_COLUMN_NAME")
      bean.physicalColumnNameAttr.value = result.getString("PHYSICAL_COLUMN_NAME")
      bean.columnCommentAttr.value = result.getString("COLUMN_COMMENT")
      bean.dataTypeAttr.value = result.getString("DATA_TYPE")
      bean.dataLengthAttr.value = result.getString("DATA_LENGTH")
      bean.dataPrecisionAttr.value = result.getString("DATA_PRECISION")
      bean.dataDefaultAttr.value = result.getString("DATA_DEFAULT")
      bean.nullableAttr.value = result.getString("NULLABLE")
      bean.pkFlgAttr.value = result.getBigDecimal("PK_FLG")
      bean.existsFlgAttr.value = result.getString("EXISTS_FLG")
      bean.torokuymdAttr.value = result.getString("TOROKUYMD")
      bean.torokuhmsAttr.value = result.getString("TOROKUHMS")
      bean.torokuuserAttr.value = result.getString("TOROKUUSER")
      bean.kosinymdAttr.value = result.getString("KOSINYMD")
      bean.kosinhmsAttr.value = result.getString("KOSINHMS")
      bean.kosinuserAttr.value = result.getString("KOSINUSER")
      bean.bikoAttr.value = result.getString("BIKO")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to TR_ERD_TAB_COLUMNS using list of TrErdTabColumnsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of TrErdTabColumnsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[TrErdTabColumnsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/INSERT_TR_ERD_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TrErdTabColumnsBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setBigDecimal(2, bean.tableIdAttr.value)
      stmt.setString(3, bean.logicalTableNameAttr.value)
      stmt.setString(4, bean.physicalTableNameAttr.value)
      stmt.setString(5, bean.tableCommentAttr.value)
      stmt.setBigDecimal(6, bean.dictColumnIdAttr.value)
      stmt.setBigDecimal(7, bean.columnIdAttr.value)
      stmt.setString(8, bean.logicalColumnNameAttr.value)
      stmt.setString(9, bean.physicalColumnNameAttr.value)
      stmt.setString(10, bean.columnCommentAttr.value)
      stmt.setString(11, bean.dataTypeAttr.value)
      stmt.setString(12, bean.dataLengthAttr.value)
      stmt.setString(13, bean.dataPrecisionAttr.value)
      stmt.setString(14, bean.dataDefaultAttr.value)
      stmt.setString(15, bean.nullableAttr.value)
      stmt.setBigDecimal(16, bean.pkFlgAttr.value)
      stmt.setString(17, bean.existsFlgAttr.value)
      stmt.setString(18, bean.torokuymdAttr.value)
      stmt.setString(19, bean.torokuhmsAttr.value)
      stmt.setString(20, bean.torokuuserAttr.value)
      stmt.setString(21, bean.kosinymdAttr.value)
      stmt.setString(22, bean.kosinhmsAttr.value)
      stmt.setString(23, bean.kosinuserAttr.value)
      stmt.setString(24, bean.bikoAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates TR_ERD_TAB_COLUMNS using list of TrErdTabColumnsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of TrErdTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[TrErdTabColumnsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/UPDATE_TR_ERD_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TrErdTabColumnsBean =>
        stmt.setBigDecimal(1, bean.trkmIdAttr.value)
        stmt.setBigDecimal(2, bean.tableIdAttr.value)
        stmt.setString(3, bean.logicalTableNameAttr.value)
        stmt.setString(4, bean.physicalTableNameAttr.value)
        stmt.setString(5, bean.tableCommentAttr.value)
        stmt.setBigDecimal(6, bean.dictColumnIdAttr.value)
        stmt.setBigDecimal(7, bean.columnIdAttr.value)
        stmt.setString(8, bean.logicalColumnNameAttr.value)
        stmt.setString(9, bean.physicalColumnNameAttr.value)
        stmt.setString(10, bean.columnCommentAttr.value)
        stmt.setString(11, bean.dataTypeAttr.value)
        stmt.setString(12, bean.dataLengthAttr.value)
        stmt.setString(13, bean.dataPrecisionAttr.value)
        stmt.setString(14, bean.dataDefaultAttr.value)
        stmt.setString(15, bean.nullableAttr.value)
        stmt.setBigDecimal(16, bean.pkFlgAttr.value)
        stmt.setString(17, bean.existsFlgAttr.value)
        stmt.setString(18, bean.torokuymdAttr.value)
        stmt.setString(19, bean.torokuhmsAttr.value)
        stmt.setString(20, bean.torokuuserAttr.value)
        stmt.setString(21, bean.kosinymdAttr.value)
        stmt.setString(22, bean.kosinhmsAttr.value)
        stmt.setString(23, bean.kosinuserAttr.value)
        stmt.setString(24, bean.bikoAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes TR_ERD_TAB_COLUMNS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean TrErdTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: TrErdTabColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/DELETE_TR_ERD_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to TR_ERD_TAB_COLUMNS using a TrErdTabColumnsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean TrErdTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: TrErdTabColumnsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/MERGE_TR_ERD_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}