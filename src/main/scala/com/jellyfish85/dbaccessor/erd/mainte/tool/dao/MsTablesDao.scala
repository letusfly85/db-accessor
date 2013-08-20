package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTablesBean
import java.sql.{Connection, SQLException, ResultSet, PreparedStatement}

class MsTablesDao extends GeneralDao[MsTablesBean] {

  /**
   * テーブルマスタ検索
   *
   * @param conn
   * @param bean テーブル名（物理）を検索キーとする
   * @return テーブルマスタ明細を返却する
   */
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

  def insert(conn: Connection, list: List[MsTablesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    try {
      list.foreach {bean: MsTablesBean =>
        stmt.setBigDecimal(1, bean.trkmIdAttr.value)
        stmt.setBigDecimal(2, bean.tabDefIdAttr.value)
        stmt.setBigDecimal(3, bean.tableIdAttr.value)
        stmt.setBigDecimal(4, bean.revisionAttr.value)
        stmt.setString(5, bean.logicalTableTagAttr.value)
        stmt.setString(6, bean.logicalTableNameAttr.value)
        stmt.setString(7, bean.physicalTableNameAttr.value)
        stmt.setString(8, bean.trkmStatusAttr.value)
        stmt.setString(9, bean.tableCommentAttr.value)
        stmt.setString(10, bean.segoseiCheckStatusAttr.value)
        stmt.setBigDecimal(11, bean.ticketNumberAttr.value)
        stmt.setString(12, bean.existsFlgAttr.value)

        stmt.addBatch()
      }

      result = stmt.executeBatch().size

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
    }

    result
  }

  def update(conn: Connection, list: List[MsTablesBean]) : Int = {
    val result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsTablesBean): Int = {
    var result: Int = 0

    val sql  = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_TABLES.sql")
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

  /**
   * テーブルマスタマージ
   *
   * @param conn
   * @param bean
   * @return
   */
  def merge(conn: Connection,  bean: MsTablesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    try {

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
      stmt.setBigDecimal(11, bean.revisionAttr.value)
      stmt.setString(12, bean.logicalTableNameAttr.value)
      stmt.setString(13, bean.physicalTableNameAttr.value)
      stmt.setString(14, bean.trkmStatusAttr.value)
      stmt.setString(15, bean.tableCommentAttr.value)
      stmt.setString(16, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(17, bean.ticketNumberAttr.value)
      stmt.setString(18, bean.existsFlgAttr.value)

      result = stmt.executeUpdate()

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException

    } finally {
      stmt.close()
    }

    result
  }
}
