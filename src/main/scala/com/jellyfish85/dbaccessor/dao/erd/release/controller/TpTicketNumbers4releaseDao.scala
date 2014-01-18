package com.jellyfish85.dbaccessor.dao.erd.release.controller

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.release.controller.TpTicketNumbers4releaseBean
import java.math.BigDecimal

/**
 * == TpTicketNumbers4releaseDao ==
 *
 */
class TpTicketNumbers4releaseDao extends GeneralDao[TpTicketNumbers4releaseBean] {
  /**
   * == find ==
   *
   * it searches TP_TICKET_NUMBERS4RELEASE by primary keys, and returns list of TpTicketNumbers4releaseBean
   *
   *
   * @param conn JDBC Connection
   * @param bean TpTicketNumbers4releaseBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TP_TICKET_NUMBERS4RELEASE
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: TpTicketNumbers4releaseBean): List[TpTicketNumbers4releaseBean] = {
    var list: List[TpTicketNumbers4releaseBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/release/controller/SELECT_TP_TICKET_NUMBERS4RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.releaseIdAttr.value)
    stmt.setBigDecimal(2, bean.trkmIdAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: TpTicketNumbers4releaseBean = new TpTicketNumbers4releaseBean

      bean.releaseIdAttr.value = result.getBigDecimal("RELEASE_ID")
      bean.trkmIdAttr.value = result.getBigDecimal("TRKM_ID")
      bean.ticketNumberAttr.value = result.getBigDecimal("TICKET_NUMBER")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findMaxTrkmId ==
   *
   * it searches max trkm id of TP_TICKET_NUMBERS4RELEASE by primary keys, and returns BigDecimal
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TP_TICKET_NUMBERS4RELEASE
   */
  @throws(classOf[SQLException])
  def findMaxTrkmId(conn: Connection): BigDecimal = {
    val sql:  String = generateSimpleQuery("/query/erd/release/controller/SELECT_TP_TICKET_NUMBERS4RELEASE_MAX_TRKM_ID.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    var maxTrkmId: BigDecimal = null

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      maxTrkmId = result.getBigDecimal("TRKM_ID")
    }
    stmt.close()

    maxTrkmId
  }

  /**
   * == insert ==
   *
   * it inserts to TP_TICKET_NUMBERS4RELEASE using list of TpTicketNumbers4releaseBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of TpTicketNumbers4releaseBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[TpTicketNumbers4releaseBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/INSERT_TP_TICKET_NUMBERS4RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TpTicketNumbers4releaseBean =>
      stmt.setBigDecimal(1, bean.releaseIdAttr.value)
      stmt.setBigDecimal(2, bean.trkmIdAttr.value)
      stmt.setBigDecimal(3, bean.ticketNumberAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates TP_TICKET_NUMBERS4RELEASE using list of TpTicketNumbers4releaseBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of TpTicketNumbers4releaseBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[TpTicketNumbers4releaseBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/UPDATE_TP_TICKET_NUMBERS4RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TpTicketNumbers4releaseBean =>
      stmt.setBigDecimal(1, bean.releaseIdAttr.value)
      stmt.setBigDecimal(2, bean.trkmIdAttr.value)
      stmt.setBigDecimal(3, bean.ticketNumberAttr.value)

      stmt.setBigDecimal(4, bean.releaseIdAttr.value)
      stmt.setBigDecimal(5, bean.trkmIdAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes TP_TICKET_NUMBERS4RELEASE by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean TpTicketNumbers4releaseBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: TpTicketNumbers4releaseBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/DELETE_TP_TICKET_NUMBERS4RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.releaseIdAttr.value)
    stmt.setBigDecimal(2, bean.trkmIdAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to TP_TICKET_NUMBERS4RELEASE using a TpTicketNumbers4releaseBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean TpTicketNumbers4releaseBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: TpTicketNumbers4releaseBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/release/controller/MERGE_TP_TICKET_NUMBERS4RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}