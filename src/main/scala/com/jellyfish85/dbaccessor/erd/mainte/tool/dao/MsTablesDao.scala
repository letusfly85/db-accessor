package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTablesBean
import java.sql.{ResultSet, PreparedStatement}

class MsTablesDao extends GeneralDao[MsTablesBean] {

  /**
   * テーブルマスタ検索
   *
   * @param db
   * @param bean
   * @return テーブルマスタ明細を返却する
   */
  def find(db: DatabaseManager,   bean: MsTablesBean): List[MsTablesBean] = {
    var list: List[MsTablesBean] = List()

    try {
      val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES.sql")
      val stmt: PreparedStatement = db.conn.prepareStatement(sql)
      stmt.setString(1, bean.physicalTableNameAttr.value)

      val result: ResultSet = stmt.executeQuery()

      while (result.next()) {
        val bean: MsTablesBean = new MsTablesBean()

        bean.trkmIdAttr.value = result.getInt("TRKM_ID")
        bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")

        list ::= bean
      }
    }

    list
  }

  def insert(db: DatabaseManager, bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def update(db: DatabaseManager, bean: MsTablesBean) : BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def delete(db: DatabaseManager, bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def merge(db: DatabaseManager,  bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }
}
