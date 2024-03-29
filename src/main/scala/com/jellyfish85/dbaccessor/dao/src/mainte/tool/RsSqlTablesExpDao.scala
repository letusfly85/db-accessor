package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSqlTablesExpBean

/**
 * == RsSqlTablesExpDao ==
 *
 */
class RsSqlTablesExpDao extends GeneralDao[RsSqlTablesExpBean] {
  /**
   * == find ==
   *
   * it searches RS_SQL_TABLES_EXP by primary keys, and returns list of RsSqlTablesExpBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSqlTablesExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SQL_TABLES_EXP
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsSqlTablesExpBean): List[RsSqlTablesExpBean] = {
    var list: List[RsSqlTablesExpBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setBigDecimal(2, bean.subLineAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSqlTablesExpBean = new RsSqlTablesExpBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.subLineAttr.value = result.getBigDecimal("SUB_LINE")
      bean.tableNameAttr.value = result.getString("TABLE_NAME")
      bean.tableAliasAttr.value = result.getString("TABLE_ALIAS")
      bean.callTypeAttr.value = result.getString("CALL_TYPE")
      bean.crudTypeAttr.value = result.getString("CRUD_TYPE")
      bean.depthAttr.value = result.getBigDecimal("DEPTH")
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
   * it inserts to RS_SQL_TABLES_EXP using list of RsSqlTablesExpBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSqlTablesExpBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsSqlTablesExpBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSqlTablesExpBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.subLineAttr.value)
      stmt.setString(6, bean.tableNameAttr.value)
      stmt.setString(7, bean.tableAliasAttr.value)
      stmt.setString(8, bean.callTypeAttr.value)
      stmt.setString(9, bean.crudTypeAttr.value)
      stmt.setBigDecimal(10, bean.depthAttr.value)
      stmt.setBigDecimal(11, bean.revisionAttr.value)
      stmt.setString(12, bean.authorAttr.value)
      stmt.setString(13, bean.commitYmdAttr.value)
      stmt.setString(14, bean.commitHmsAttr.value)
      stmt.setString(15, bean.extensionAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates RS_SQL_TABLES_EXP using list of RsSqlTablesExpBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSqlTablesExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsSqlTablesExpBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSqlTablesExpBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.subLineAttr.value)
      stmt.setString(6, bean.tableNameAttr.value)
      stmt.setString(7, bean.tableAliasAttr.value)
      stmt.setString(8, bean.callTypeAttr.value)
      stmt.setString(9, bean.crudTypeAttr.value)
      stmt.setBigDecimal(10, bean.depthAttr.value)
      stmt.setBigDecimal(11, bean.revisionAttr.value)
      stmt.setString(12, bean.authorAttr.value)
      stmt.setString(13, bean.commitYmdAttr.value)
      stmt.setString(14, bean.commitHmsAttr.value)
      stmt.setString(15, bean.extensionAttr.value)

      stmt.setString(16, bean.pathAttr.value)
      stmt.setBigDecimal(17, bean.subLineAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SQL_TABLES_EXP by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsSqlTablesExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsSqlTablesExpBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    stmt.setBigDecimal(2, bean.subLineAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == truncate ==
   *
   * it truncates RS_SQL_TABLES_EXP.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def truncate(conn: Connection): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/TRUNCATE_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_SQL_TABLES_EXP using a RsSqlTablesExpBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsSqlTablesExpBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSqlTablesExpBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_SQL_TABLES_EXP.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}