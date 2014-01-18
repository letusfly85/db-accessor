package com.jellyfish85.dbaccessor.dao.erd.release.controller

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.release.controller.KrTrkmStatusBean
import java.util

import scala.collection.JavaConversions._

/**
 * == KrTrkmStatusDao ==
 *
 */
class KrTrkmStatusDao extends GeneralDao[KrTrkmStatusBean] {
  /**
   * == find ==
   *
   * it searches KR_TRKM_STATUS by primary keys, and returns list of KrTrkmStatusBean
   *
   *
   * @param conn JDBC Connection
   * @param bean KrTrkmStatusBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_TRKM_STATUS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: KrTrkmStatusBean): List[KrTrkmStatusBean] = {
    var list: List[KrTrkmStatusBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/release/controller/SELECT_KR_TRKM_STATUS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.trkmIdAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrTrkmStatusBean = new KrTrkmStatusBean

      bean.trkmIdAttr.value = result.getBigDecimal("TRKM_ID")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      bean.currentFlgAttr.value = result.getString("CURRENT_FLG")
      bean.trkmYmdAttr.value = result.getString("TRKM_YMD")
      bean.trkmHhmissAttr.value = result.getString("TRKM_HHMISS")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == find ==
   *
   * it searches KR_TRKM_STATUS by primary keys, and returns list of KrTrkmStatusBean
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_TRKM_STATUS
   */
  @throws(classOf[SQLException])
  def findCurrent(conn: Connection): KrTrkmStatusBean = {
    var list: List[KrTrkmStatusBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/release/controller/SELECT_KR_TRKM_STATUS_CURRENT.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrTrkmStatusBean = new KrTrkmStatusBean

      bean.trkmIdAttr.value = result.getBigDecimal("TRKM_ID")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      bean.currentFlgAttr.value = result.getString("CURRENT_FLG")
      bean.trkmYmdAttr.value = result.getString("TRKM_YMD")
      bean.trkmHhmissAttr.value = result.getString("TRKM_HHMISS")

      list ::= bean
    }
    stmt.close()

    if (list.isEmpty) {
      throw new RuntimeException("list is empty")
    }

    if (list.size > 1) {
      throw new RuntimeException("records are duplicate")
    }

    list.head
  }

  /**
   * == insert ==
   *
   * it inserts to KR_TRKM_STATUS using list of KrTrkmStatusBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of KrTrkmStatusBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[KrTrkmStatusBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/INSERT_KR_TRKM_STATUS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrTrkmStatusBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setString(2, bean.trkmStatusAttr.value)
      stmt.setString(3, bean.currentFlgAttr.value)
      stmt.setString(4, bean.trkmYmdAttr.value)
      stmt.setString(5, bean.trkmHhmissAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == insert ==
   *
   * it inserts to KR_TRKM_STATUS using list of KrTrkmStatusBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of KrTrkmStatusBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: util.ArrayList[KrTrkmStatusBean]): Int  = {
    insert(conn, list.toList)
  }

  /**
   * == update ==
   *
   * it updates KR_TRKM_STATUS using list of KrTrkmStatusBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of KrTrkmStatusBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[KrTrkmStatusBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/UPDATE_KR_TRKM_STATUS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrTrkmStatusBean =>
      stmt.setBigDecimal(1, bean.trkmIdAttr.value)
      stmt.setString(2, bean.trkmStatusAttr.value)
      stmt.setString(3, bean.currentFlgAttr.value)

      stmt.setBigDecimal(4, bean.trkmIdAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_TRKM_STATUS using list of KrTrkmStatusBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of KrTrkmStatusBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: util.ArrayList[KrTrkmStatusBean]): Int = {
    update(conn, list.toList)
  }

  /**
   * == delete ==
   *
   * it deletes KR_TRKM_STATUS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean KrTrkmStatusBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: KrTrkmStatusBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/DELETE_KR_TRKM_STATUS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to KR_TRKM_STATUS using a KrTrkmStatusBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean KrTrkmStatusBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: KrTrkmStatusBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/MERGE_KR_TRKM_STATUS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}