package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTextExpBean
import java.util

/**
 * == RsSqlTextExpDao ==
 *
 */
class RsSqlTextExpDao extends GeneralDao[RsSqlTextExpBean] {
  /**
   * == find ==
   *
   * it searches RS_SQL_TEXT_EXP by primary keys, and returns list of RsSqlTextExpBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSqlTextExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SQL_TEXT_EXP
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsSqlTextExpBean): List[RsSqlTextExpBean] = {
    var list: List[RsSqlTextExpBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SQL_TEXT_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setBigDecimal(2, bean.subLineAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSqlTextExpBean = new RsSqlTextExpBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.subLineAttr.value = result.getBigDecimal("SUB_LINE")
      bean.lineAttr.value = result.getBigDecimal("LINE")
      bean.textAttr.value = result.getString("TEXT")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.extensionAttr.value = result.getString("EXTENSION")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findSummary ==
   *
   * it searches RS_SQL_TEXT by primary keys, and returns list of RsSqlTextBean
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SQL_TEXT
   */
  @throws(classOf[SQLException])
  def findSummary(conn: Connection): List[RsSqlTextExpBean] = {
    var list: List[RsSqlTextExpBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SQL_TEXT_EXP_SUMMARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSqlTextExpBean = new RsSqlTextExpBean

      bean.pathAttr.value = result.getString("PATH")
      bean.subLineAttr.value = result.getBigDecimal("SUB_LINE")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RS_SQL_TEXT_EXP using list of RsSqlTextExpBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSqlTextExpBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsSqlTextExpBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_SQL_TEXT_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSqlTextExpBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.lineAttr.value)
      stmt.setBigDecimal(6, bean.subLineAttr.value)
      stmt.setString(7, bean.textAttr.value)
      stmt.setBigDecimal(8, bean.revisionAttr.value)
      stmt.setString(9, bean.authorAttr.value)
      stmt.setString(10, bean.commitYmdAttr.value)
      stmt.setString(11, bean.commitHmsAttr.value)
      stmt.setString(12, bean.extensionAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == insert ==
   *
   * it inserts to RS_SQL_CDATA using list of RsSqlCdataBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSqlCdataBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: util.ArrayList[RsSqlTextExpBean]): Int  = {
    var targetList: List[RsSqlTextExpBean] = List()

    for (i <- 0 to list.size()-1) {
      targetList ::= list.get(i)
    }

    insert(conn, targetList)
  }

  /**
   * == update ==
   *
   * it updates RS_SQL_TEXT_EXP using list of RsSqlTextExpBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSqlTextExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsSqlTextExpBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_SQL_TEXT_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSqlTextExpBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.lineAttr.value)
      stmt.setBigDecimal(6, bean.subLineAttr.value)
      stmt.setString(7, bean.textAttr.value)
      stmt.setBigDecimal(8, bean.revisionAttr.value)
      stmt.setString(9, bean.authorAttr.value)
      stmt.setString(10, bean.commitYmdAttr.value)
      stmt.setString(11, bean.commitHmsAttr.value)
      stmt.setString(12, bean.extensionAttr.value)

      stmt.setString(13, bean.pathAttr.value)
      stmt.setBigDecimal(14, bean.subLineAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SQL_TEXT_EXP by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsSqlTextExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsSqlTextExpBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SQL_TEXT_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_SQL_TEXT_EXP using a RsSqlTextExpBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsSqlTextExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSqlTextExpBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_SQL_TEXT_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}