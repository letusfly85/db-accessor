package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndexesBean
import java.sql.{PreparedStatement, Connection}

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
    val result: Int = 0

    result
  }

  def update(conn: Connection, list: List[MsIndexesBean]): Int = {
    val result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

  def merge(conn: Connection,  bean: MsIndexesBean): Int = {
    //TODO 実装

    val result: Int = 0

    result
  }

}
