package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.KrNasaTableSeqBean

/**
 * == KrNasaTableSeqDao ==
 *
 */
class KrNasaTableSeqDao extends GeneralDao[KrNasaTableSeqBean] {
  /**
   * == find ==
   *
   * it searches KR_NASA_TABLE_SEQ by primary keys, and returns list of KrNasaTableSeqBean
   *
   *
   * @param conn JDBC Connection
   * @param bean KrNasaTableSeqBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_NASA_TABLE_SEQ
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: KrNasaTableSeqBean): List[KrNasaTableSeqBean] = {
    var list: List[KrNasaTableSeqBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_KR_NASA_TABLE_SEQ.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.tableNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrNasaTableSeqBean = new KrNasaTableSeqBean

      bean.tableNameAttr.value = result.getString("TABLE_NAME")
      bean.currentIdAttr.value = result.getBigDecimal("CURRENT_ID")
      bean.previousIdAttr.value = result.getBigDecimal("PREVIOUS_ID")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to KR_NASA_TABLE_SEQ using list of KrNasaTableSeqBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of KrNasaTableSeqBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[KrNasaTableSeqBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_KR_NASA_TABLE_SEQ.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrNasaTableSeqBean =>
      stmt.setString(1, bean.tableNameAttr.value)
      stmt.setBigDecimal(2, bean.currentIdAttr.value)
      stmt.setBigDecimal(3, bean.previousIdAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_NASA_TABLE_SEQ using list of KrNasaTableSeqBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of KrNasaTableSeqBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[KrNasaTableSeqBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_KR_NASA_TABLE_SEQ.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrNasaTableSeqBean =>
      stmt.setString(1, bean.tableNameAttr.value)
      stmt.setBigDecimal(2, bean.currentIdAttr.value)
      stmt.setBigDecimal(3, bean.previousIdAttr.value)
      stmt.setString(4, bean.tableNameAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_NASA_TABLE_SEQ using list of KrNasaTableSeqBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, bean: KrNasaTableSeqBean): Int = {
    var result: Int = 0

    result = update(conn, List(bean))

    result
  }

  /**
   * == delete ==
   *
   * it deletes KR_NASA_TABLE_SEQ by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean KrNasaTableSeqBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: KrNasaTableSeqBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_KR_NASA_TABLE_SEQ.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to KR_NASA_TABLE_SEQ using a KrNasaTableSeqBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean KrNasaTableSeqBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: KrNasaTableSeqBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_KR_NASA_TABLE_SEQ.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}