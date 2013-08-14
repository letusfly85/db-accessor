package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.{MsTabColumnsBean}
import java.sql.{Connection, SQLException, ResultSet, PreparedStatement}

class MsTabColumnsDao extends GeneralDao[MsTabColumnsBean] {

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

  def insert(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def update(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def merge(conn: Connection,  bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }
}
