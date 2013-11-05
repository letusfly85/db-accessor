package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsConfigAttributesBean
import java.util

/**
 * == RsConfigAttributesDao ==
 *
 */
class RsConfigAttributesDao extends GeneralDao[RsConfigAttributesBean] {
  /**
   * == find ==
   *
   * it searches RS_CONFIG_ATTRIBUTES by primary keys, and returns list of RsConfigAttributesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsConfigAttributesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_CONFIG_ATTRIBUTES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsConfigAttributesBean): List[RsConfigAttributesBean] = {
    var list: List[RsConfigAttributesBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_CONFIG_ATTRIBUTES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsConfigAttributesBean = new RsConfigAttributesBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.actionNameAttr.value = result.getString("ACTION_NAME")
      bean.subjectIdAttr.value = result.getString("SUBJECT_ID")
      bean.fromIdAttr.value = result.getString("FROM_ID")
      bean.toIdAttr.value = result.getString("TO_ID")
      bean.nextActionNameAttr.value = result.getString("NEXT_ACTION_NAME")
      bean.extensionAttr.value = result.getString("EXTENSION")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * it inserts to RS_CONFIG_ATTRIBUTES using list of RsConfigAttributesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsConfigAttributesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsConfigAttributesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_CONFIG_ATTRIBUTES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsConfigAttributesBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.authorAttr.value)
      stmt.setString(7, bean.commitYmdAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)
      stmt.setString(9, bean.actionNameAttr.value)
      stmt.setString(10, bean.subjectIdAttr.value)
      stmt.setString(11, bean.fromIdAttr.value)
      stmt.setString(12, bean.toIdAttr.value)
      stmt.setString(13, bean.nextActionNameAttr.value)
      stmt.setString(14, bean.extensionAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == insert ==
   *
   * it inserts to RS_CONFIG_ATTRIBUTES using list of RsConfigAttributesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsConfigAttributesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: util.ArrayList[RsConfigAttributesBean]): Int  = {
    var targetList: List[RsConfigAttributesBean] = List()

    for (i <- 0 to list.size() -1) {
      targetList ::= list.get(i)
    }

    insert(conn, targetList)
  }

  /**
   * == update ==
   *
   * it updates RS_CONFIG_ATTRIBUTES using list of RsConfigAttributesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsConfigAttributesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsConfigAttributesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_CONFIG_ATTRIBUTES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsConfigAttributesBean =>

      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_CONFIG_ATTRIBUTES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsConfigAttributesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsConfigAttributesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_CONFIG_ATTRIBUTES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }

  /**
   * == deleteAll ==
   *
   * it deletes RS_CONFIG_ATTRIBUTES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def deleteAll(conn: Connection): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_CONFIG_ATTRIBUTES_ALL.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_CONFIG_ATTRIBUTES using a RsConfigAttributesBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsConfigAttributesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsConfigAttributesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_CONFIG_ATTRIBUTES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}