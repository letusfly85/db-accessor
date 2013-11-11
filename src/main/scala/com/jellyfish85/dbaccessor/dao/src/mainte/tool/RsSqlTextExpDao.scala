package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTextExpBean

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

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSqlTextExpBean = new RsSqlTextExpBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
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
      stmt.setString(6, bean.textAttr.value)
      stmt.setBigDecimal(7, bean.revisionAttr.value)
      stmt.setString(8, bean.authorAttr.value)
      stmt.setString(9, bean.commitYmdAttr.value)
      stmt.setString(10, bean.commitHmsAttr.value)
      stmt.setString(11, bean.extensionAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
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
      stmt.setString(6, bean.textAttr.value)
      stmt.setBigDecimal(7, bean.revisionAttr.value)
      stmt.setString(8, bean.authorAttr.value)
      stmt.setString(9, bean.commitYmdAttr.value)
      stmt.setString(10, bean.commitHmsAttr.value)
      stmt.setString(11, bean.extensionAttr.value)

      stmt.setString(12, bean.pathAttr.value)
      
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