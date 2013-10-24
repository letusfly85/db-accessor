package com.jellyfish85.dbaccessor.TODO.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrIndexesBean

/**
 * == RrIndexesDao ==
 *
 */
class RrIndexesDao extends GeneralDao[RrIndexesBean] {
  /**
   * == find ==
   *
   * it searches RR_INDEXES by primary keys, and returns list of RrIndexesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RrIndexesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_INDEXES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrIndexesBean): List[RrIndexesBean] = {
    var list: List[RrIndexesBean] = List()

    val sql:  String = generateSimpleQuery("/query/TODO/SELECT_RR_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrIndexesBean = new RrIndexesBean

      bean.indexNameAttr.value = result.getString("INDEX_NAME")
      bean.revisionAfAttr.value = result.getBigDecimal("REVISION_AF")
      bean.revisionBfAttr.value = result.getBigDecimal("REVISION_BF")
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

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RR_INDEXES using list of RrIndexesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RrIndexesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrIndexesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/INSERT_RR_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrIndexesBean =>
      stmt.setString(1, bean.indexNameAttr.value)
      stmt.setBigDecimal(2, bean.revisionAfAttr.value)
      stmt.setBigDecimal(3, bean.revisionBfAttr.value)
      stmt.setBigDecimal(4, bean.tableIdAttr.value)
      stmt.setBigDecimal(5, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(6, bean.ticketNumberAttr.value)
      stmt.setString(7, bean.uniquenessAttr.value)
      stmt.setString(8, bean.functionAttr.value)
      stmt.setString(9, bean.bitmapAttr.value)
      stmt.setString(10, bean.reverseAttr.value)
      stmt.setString(11, bean.keyCompressAttr.value)
      stmt.setString(12, bean.commitFlgAttr.value)
      stmt.setString(13, bean.functionFomulaAttr.value)
      stmt.setString(14, bean.localityAttr.value)
      stmt.setString(15, bean.partitionedAttr.value)
      stmt.setString(16, bean.statusAttr.value)
      stmt.setString(17, bean.pkIndexFlgAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * it updates RR_INDEXES using list of RrIndexesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RrIndexesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrIndexesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/UPDATE_RR_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrIndexesBean =>
        stmt.setString(1, bean.indexNameAttr.value)
        stmt.setBigDecimal(2, bean.revisionAfAttr.value)
        stmt.setBigDecimal(3, bean.revisionBfAttr.value)
        stmt.setBigDecimal(4, bean.tableIdAttr.value)
        stmt.setBigDecimal(5, bean.tabDefIdAttr.value)
        stmt.setBigDecimal(6, bean.ticketNumberAttr.value)
        stmt.setString(7, bean.uniquenessAttr.value)
        stmt.setString(8, bean.functionAttr.value)
        stmt.setString(9, bean.bitmapAttr.value)
        stmt.setString(10, bean.reverseAttr.value)
        stmt.setString(11, bean.keyCompressAttr.value)
        stmt.setString(12, bean.commitFlgAttr.value)
        stmt.setString(13, bean.functionFomulaAttr.value)
        stmt.setString(14, bean.localityAttr.value)
        stmt.setString(15, bean.partitionedAttr.value)
        stmt.setString(16, bean.statusAttr.value)
        stmt.setString(17, bean.pkIndexFlgAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RR_INDEXES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RrIndexesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrIndexesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/DELETE_RR_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RR_INDEXES using a RrIndexesBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RrIndexesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrIndexesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/MERGE_RR_INDEXES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}