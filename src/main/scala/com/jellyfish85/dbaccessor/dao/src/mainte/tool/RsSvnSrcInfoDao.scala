package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.src.mainte.tool.RsSvnSrcInfoBean

import java.math.BigDecimal

/**
 * == RsSvnSrcInfoDao ==
 *
 */
class RsSvnSrcInfoDao extends GeneralDao[RsSvnSrcInfoBean] {
  /**
   * == find ==
   *
   * it searches RS_SVN_SRC_INFO by primary keys, and returns list of RsSvnSrcInfoBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSvnSrcInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SVN_SRC_INFO
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RsSvnSrcInfoBean): List[RsSvnSrcInfoBean] = {
    var list: List[RsSvnSrcInfoBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSvnSrcInfoBean = new RsSvnSrcInfoBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.extensionAttr.value = result.getString("EXTENSION")

      list ::= bean
    }

    list
  }

  /**
   * == findByProjectName ==
   *
   * it searches RS_SVN_SRC_INFO by primary keys, and returns list of RsSvnSrcInfoBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RsSvnSrcInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SVN_SRC_INFO
   */
  @throws(classOf[SQLException])
  def findByProjectName(conn: Connection,   bean: RsSvnSrcInfoBean): List[RsSvnSrcInfoBean] = {
    var list: List[RsSvnSrcInfoBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SVN_SRC_INFO_BY_PROJECT_NAME.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.projectNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSvnSrcInfoBean = new RsSvnSrcInfoBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.extensionAttr.value = result.getString("EXTENSION")

      list ::= bean
    }

    list
  }

  /**
   * == findByProjectName ==
   *
   * it searches RS_SVN_SRC_INFO by primary keys, and returns list of RsSvnSrcInfoBean
   *
   *
   * @param conn JDBC Connection
   * @param extension file's extension
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RS_SVN_SRC_INFO
   */
  @throws(classOf[SQLException])
  def findByExtension(conn: Connection,   extension: String): List[RsSvnSrcInfoBean] = {
    var list: List[RsSvnSrcInfoBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SVN_SRC_INFO_BY_EXTENSION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, extension)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSvnSrcInfoBean = new RsSvnSrcInfoBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.projectNameAttr.value = result.getString("PROJECT_NAME")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitYmdAttr.value = result.getString("COMMIT_YMD")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.extensionAttr.value = result.getString("EXTENSION")

      list ::= bean
    }

    list
  }

  /**
   * == findHeadRevision ==
   *
   * it inserts to RS_SVN_SRC_INFO head revision number.
   *
   * @param conn JDBC Connection
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def findHeadRevision(conn: Connection): BigDecimal = {
    var headRevision: BigDecimal = new BigDecimal(0)

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_RS_SVN_SRC_INFO_OF_HEAD_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      headRevision = result.getBigDecimal("HEAD_REVISION")
    }

    headRevision
  }

  /**
   * == insert ==
   *
   * it inserts to RS_SVN_SRC_INFO using list of RsSvnSrcInfoBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSvnSrcInfoBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RsSvnSrcInfoBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSvnSrcInfoBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.authorAttr.value)
      stmt.setString(7, bean.commitYmdAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)
      stmt.setString(9, bean.extensionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * it updates RS_SVN_SRC_INFO using list of RsSvnSrcInfoBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RsSvnSrcInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RsSvnSrcInfoBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSvnSrcInfoBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.projectNameAttr.value)
      stmt.setString(3, bean.fileNameAttr.value)
      stmt.setString(4, bean.pathAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.authorAttr.value)
      stmt.setString(7, bean.commitYmdAttr.value)
      stmt.setString(8, bean.commitHmsAttr.value)
      stmt.setString(9, bean.extensionAttr.value)

      stmt.setString(10, bean.pathAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SVN_SRC_INFO by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RsSvnSrcInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RsSvnSrcInfoBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)
    result = stmt.executeUpdate()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RS_SVN_SRC_INFO by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def deleteAll(conn: Connection): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_RS_SVN_SRC_INFO_ALL.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RS_SVN_SRC_INFO using a RsSvnSrcInfoBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RsSvnSrcInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSvnSrcInfoBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.pathAttr.value)

    stmt.setBigDecimal(2, bean.headRevisionAttr.value)
    stmt.setString(3, bean.projectNameAttr.value)
    stmt.setString(4, bean.fileNameAttr.value)
    stmt.setBigDecimal(5, bean.revisionAttr.value)
    stmt.setString(6, bean.authorAttr.value)
    stmt.setString(7, bean.commitYmdAttr.value)
    stmt.setString(8, bean.commitHmsAttr.value)
    stmt.setString(9, bean.extensionAttr.value)

    stmt.setBigDecimal(10, bean.headRevisionAttr.value)
    stmt.setString(11, bean.projectNameAttr.value)
    stmt.setString(12, bean.fileNameAttr.value)
    stmt.setString(13, bean.pathAttr.value)
    stmt.setBigDecimal(14, bean.revisionAttr.value)
    stmt.setString(15, bean.authorAttr.value)
    stmt.setString(16, bean.commitYmdAttr.value)
    stmt.setString(17, bean.commitHmsAttr.value)
    stmt.setString(18, bean.extensionAttr.value)

    result = stmt.executeUpdate()

    result
  }
}