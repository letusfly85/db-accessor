package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsIndexesBean

class MsIndexesDao extends GeneralDao[MsIndexesBean] {

  /**
   * インデックスマスタ検索
   *
   * @param conn コネクション
   * @param bean インデックス名（物理）
   * @return インデックスマスタビーン
   */
  def find(conn: Connection,   bean: MsIndexesBean): List[MsIndexesBean] = {
    var list: List[MsIndexesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.indexNameAttr.value)
    try {
      val result = stmt.executeQuery()
      while (result.next()) {
        val bean: MsIndexesBean = new MsIndexesBean()

        bean.indexNameAttr.value = result.getString("INDEX_NAME")
        bean.revisionAttr.value = result.getBigDecimal("REVISION")
        bean.tableIdAttr.value = result.getBigDecimal("TABLE_ID")
        bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
        bean.ticketNumberAttr.value = result.getBigDecimal("TICKET_NUMBER")
        bean.uniquenessAttr.value = result.getString("UNIQUENESS")
        bean.functionAttr.value = result.getString("FUNCTION")
        bean.bitmapAttr.value = result.getString("BITMAP")
        bean.reverseAttr.value = result.getString("REVERSE")
        bean.keyCompressAttr.value = result.getString("KEY_COMPRESS")
        bean.commitFlgAttr.value = result.getString("COMMIT_FLG")
        bean.functionFomulaAttr.value = result.getString("FUNCTION_FOMULA")
        bean.localityAttr.value = result.getString("LOCALITY")
        bean.partitionedAttr.value = result.getString("PARTITIONED")
        bean.statusAttr.value = result.getString("STATUS")
        bean.pkIndexFlgAttr.value = result.getString("PK_INDEX_FLG")

        list ::= bean
      }
    }

    list
  }

  def insert(conn: Connection, list: List[MsIndexesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    try {
      list.foreach {bean: MsIndexesBean =>
        stmt.setString(1, bean.indexNameAttr.value)
        stmt.setBigDecimal(2, bean.revisionAttr.value)
        stmt.setBigDecimal(3, bean.tableIdAttr.value)
        stmt.setBigDecimal(4, bean.tabDefIdAttr.value)
        stmt.setBigDecimal(5, bean.ticketNumberAttr.value)
        stmt.setString(6, bean.uniquenessAttr.value)
        stmt.setString(7, bean.functionAttr.value)
        stmt.setString(8, bean.bitmapAttr.value)
        stmt.setString(9, bean.reverseAttr.value)
        stmt.setString(10, bean.keyCompressAttr.value)
        stmt.setString(11, bean.commitFlgAttr.value)
        stmt.setString(12, bean.functionFomulaAttr.value)
        stmt.setString(13, bean.localityAttr.value)
        stmt.setString(14, bean.partitionedAttr.value)
        stmt.setString(15, bean.statusAttr.value)
        stmt.setString(16, bean.pkIndexFlgAttr.value)

        stmt.addBatch()
      }

      result = stmt.executeBatch().size

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new SQLException()
    }

    result
  }

  def update(conn: Connection, list: List[MsIndexesBean]): Int = {
    val result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsIndexesBean): Int = {
    var result: Int = 0

    val sql  = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_INDEXES.sql")
    val stmt = conn.prepareStatement(sql)

    try {
      stmt.setString(1, bean.indexNameAttr.value)

      result = stmt.executeUpdate()

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException("")
    }

    result
  }

  def merge(conn: Connection,  bean: MsIndexesBean): Int = {
    //TODO 実装

    val result: Int = 0

    result
  }

}
