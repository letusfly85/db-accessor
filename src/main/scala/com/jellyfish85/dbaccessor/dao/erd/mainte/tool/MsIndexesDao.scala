package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{ResultSet, SQLException, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsIndexesBean

import java.math.BigDecimal
import java.util

class MsIndexesDao extends GeneralDao[MsIndexesBean] {

  /**
   * == find ==
   *
   * it searches MS_INDEXES by primary keys, and returns list of TrErdTabColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean TrErdTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_ERD_TAB_COLUMNS
   */
  @throws(classOf[SQLException])
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

    stmt.close()
    list
  }

  /**
   * == findByTableId ==
   *
   * it searches MS_INDEXES by primary keys, and returns list of TrErdTabColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @param tableId tableId
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_ERD_TAB_COLUMNS
   */
  @throws(classOf[SQLException])
  def findByTableId(conn: Connection,   tableId: BigDecimal ): List[MsIndexesBean] = {
    var list: List[MsIndexesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_INDEXES_BY_TABLE_ID.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, tableId)
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

    stmt.close()
    list
  }

  /**
   * == findAll ==
   *
   * it searches MS_INDEXES, and returns all list of TrErdTabColumnsBean
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_ERD_TAB_COLUMNS
   */
  @throws(classOf[SQLException])
  def findAll(conn: Connection): List[MsIndexesBean] = {
    var list: List[MsIndexesBean] = List()

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_INDEXES_ALL_WITH_MS_TABLES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    try {
      val result = stmt.executeQuery()
      while (result.next()) {
        val bean: MsIndexesBean = new MsIndexesBean()

        bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
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

    stmt.close()
    list
  }

  /**
   * == findByIndexNames ==
   *
   * it searches MS_INDEXES by primary keys, and returns list of MsIndexesBean
   *
   *
   * @param conn JDBC Connection
   * @param indexNames table name list
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_INDEXES
   */
  @throws(classOf[SQLException])
  def findByIndexNames(conn: Connection,   indexNames: List[String]): List[MsIndexesBean] = {
    var list: List[MsIndexesBean] = List()

    val map: Map[String, List[String]] = Map("indexNames" -> indexNames)
    val sql: String = generateSQLIncludesList("/query/erd/mainte/tool/SELECT_MS_INDEXES_BY_INDEX_NAMES.sql", map)

    val stmt: PreparedStatement = conn.prepareStatement(sql)
    try {
      var i: Int = 1
      indexNames.foreach {v =>
        stmt.setString(i, v)
        i += 1
      }
      val result: ResultSet = stmt.executeQuery()

      while (result.next()) {
        val bean: MsIndexesBean = new MsIndexesBean()

        bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
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

    } catch {
      case e: SQLException =>
        println(sql)
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException

    } finally {
      stmt.close()
    }

    list
  }

  /**
   * == findByIndexNames ==
   *
   * it searches MS_INDEXES by primary keys, and returns list of MsIndexesBean
   *
   *
   * @param conn JDBC Connection
   * @param _indexNames table name list
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_INDEXES
   */
  @throws(classOf[SQLException])
  def findByIndexNames(conn: Connection,   _indexNames: util.ArrayList[String]): List[MsIndexesBean] = {
    var indexNames: List[String] = List()
    for (i <- 0 until _indexNames.size()){
      val indexName: String = _indexNames.get(i)
      indexNames ::= indexName
    }

    return findByIndexNames(conn, indexNames)
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
      stmt.close()

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
      stmt.close()

    } catch {
      case e: SQLException =>
        conn.rollback()
        e.printStackTrace()
        throw new RuntimeException("")
    }

    result
  }

  def merge(conn: Connection,  bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

}
