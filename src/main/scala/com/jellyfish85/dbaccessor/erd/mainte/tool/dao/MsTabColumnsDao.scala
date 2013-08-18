package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.{MsTabColumnsBean}
import java.sql.{Connection, SQLException, ResultSet, PreparedStatement}

class MsTabColumnsDao extends GeneralDao[MsTabColumnsBean] {

  /**
   * カラムマスタ検索
   *
   * @param conn
   * @param bean
   * @return
   */
  def find(conn: Connection,   bean: MsTabColumnsBean): List[MsTabColumnsBean] = {
    var list: List[MsTabColumnsBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)
    try {
      stmt.setString(1, bean.physicalTableNameAttr.value)

      val result: ResultSet = stmt.executeQuery()

      while (result.next()) {
        val bean: MsTabColumnsBean = new MsTabColumnsBean

        bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
        bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
        bean.revisionAttr.value = result.getBigDecimal("REVISION")
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
   * カラムマスタ登録
   *
   * @param conn
   * @param list
   * @return
   */
  def insert(conn: Connection, list: List[MsTabColumnsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    try {
      list.foreach {bean: MsTabColumnsBean =>
        stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
        stmt.setBigDecimal(2, bean.tableIdAttr.value)
        stmt.setBigDecimal(3, bean.revisionAttr.value)
        stmt.setString(4, bean.logicalTableNameAttr.value)
        stmt.setString(5, bean.physicalTableNameAttr.value)
        stmt.setString(6, bean.tableCommentAttr.value)
        stmt.setBigDecimal(7, bean.columnIdAttr.value)
        stmt.setString(8, bean.logicalColumnNameAttr.value)
        stmt.setString(9, bean.physicalColumnNameAttr.value)
        stmt.setString(10, bean.columnCommentAttr.value)
        stmt.setString(11, bean.dataTypeAttr.value)
        stmt.setString(12, bean.dataLengthAttr.value)
        stmt.setString(13, bean.dataPrecisionAttr.value)
        stmt.setString(14, bean.dataDefaultAttr.value)
        stmt.setString(15, bean.pkFlgAttr.value)
        stmt.setString(16, bean.nullableAttr.value)
        stmt.setString(17, bean.trkmStatusAttr.value)
        stmt.setBigDecimal(18, bean.ticketNumberAttr.value)
        stmt.setString(19, bean.existsFlgAttr.value)

        stmt.execute()
        result += 1
      }

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException("")
    }

    result
  }

  def update(conn: Connection, list: List[MsTabColumnsBean]): Int = {
    var result: Int = 0

    result
  }

  /**
   * カラムマスタ削除
   *
   * @param conn
   * @param bean
   * @return
   */
  def delete(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    val sql  = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_TAB_COLUMNS.sql")
    val stmt = conn.prepareStatement(sql)

    try {
      stmt.setBigDecimal(1, bean.tableIdAttr.value)
      stmt.setString(2, bean.physicalTableNameAttr.value)

      result = stmt.executeUpdate()

    } catch {
    case e: SQLException =>
      conn.rollback()
      e.printStackTrace()
      throw new RuntimeException("")
    }

    result
  }

  def merge(conn: Connection,  bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }
}
