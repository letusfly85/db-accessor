package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.TrCommitHistoryBean
import java.util

/**
 * == TrCommitHistoryDao ==
 *
 */
class TrCommitHistoryDao extends GeneralDao[TrCommitHistoryBean] {
  /**
   * == find ==
   *
   * it searches TR_COMMIT_HISTORY by primary keys, and returns list of TrCommitHistoryBean
   *
   *
   * @param conn JDBC Connection
   * @param bean TrCommitHistoryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_COMMIT_HISTORY
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: TrCommitHistoryBean): List[TrCommitHistoryBean] = {
    var list: List[TrCommitHistoryBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_TR_COMMIT_HISTORY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.repositoryNameAttr.value)
    stmt.setString(2, bean.rootUrlAttr.value)
    stmt.setString(3, bean.rightBaseUrlAttr.value)
    stmt.setString(4, bean.leftBaseUrlAttr.value)
    stmt.setString(5, bean.pathAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: TrCommitHistoryBean = new TrCommitHistoryBean

      bean.repositoryKindAttr.value = result.getString("REPOSITORY_KIND")
      bean.repositoryNameAttr.value = result.getString("REPOSITORY_NAME")
      bean.rootUrlAttr.value = result.getString("ROOT_URL")
      bean.rightBaseUrlAttr.value = result.getString("RIGHT_BASE_URL")
      bean.leftBaseUrlAttr.value = result.getString("LEFT_BASE_URL")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.committerAttr.value = result.getString("COMMITTER")
      bean.commentsAttr.value = result.getString("COMMENTS")
      bean.actionAttr.value = result.getString("ACTION")
      bean.pathAttr.value = result.getString("PATH")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == find ==
   *
   * it searches TR_COMMIT_HISTORY by primary keys, and returns list of TrCommitHistoryBean
   *
   *
   * @param conn JDBC Connection
   * @param bean TrCommitHistoryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of TR_COMMIT_HISTORY
   */
  @throws(classOf[SQLException])
  def findBy2URL(conn: Connection,   bean: TrCommitHistoryBean): List[TrCommitHistoryBean] = {
    var list: List[TrCommitHistoryBean] = List()

    val sql:  String = generateSimpleQuery("/query/src/mainte/tool/SELECT_TR_COMMIT_HISTORY_BY_TWO_URL.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.repositoryNameAttr.value)
    stmt.setString(2, bean.rootUrlAttr.value)
    stmt.setString(3, bean.rightBaseUrlAttr.value)
    stmt.setString(4, bean.leftBaseUrlAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: TrCommitHistoryBean = new TrCommitHistoryBean

      bean.repositoryKindAttr.value = result.getString("REPOSITORY_KIND")
      bean.repositoryNameAttr.value = result.getString("REPOSITORY_NAME")
      bean.rootUrlAttr.value = result.getString("ROOT_URL")
      bean.rightBaseUrlAttr.value = result.getString("RIGHT_BASE_URL")
      bean.leftBaseUrlAttr.value = result.getString("LEFT_BASE_URL")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.committerAttr.value = result.getString("COMMITTER")
      bean.commentsAttr.value = result.getString("COMMENTS")
      bean.actionAttr.value = result.getString("ACTION")
      bean.pathAttr.value = result.getString("PATH")
      bean.fileNameAttr.value = result.getString("FILE_NAME")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to TR_COMMIT_HISTORY using list of TrCommitHistoryBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of TrCommitHistoryBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[TrCommitHistoryBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/INSERT_TR_COMMIT_HISTORY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TrCommitHistoryBean =>
      stmt.setString(1, bean.repositoryKindAttr.value)
      stmt.setString(2, bean.repositoryNameAttr.value)
      stmt.setString(3, bean.rootUrlAttr.value)
      stmt.setString(4, bean.rightBaseUrlAttr.value)
      stmt.setString(5, bean.leftBaseUrlAttr.value)
      stmt.setBigDecimal(6, bean.revisionAttr.value)
      stmt.setString(7, bean.committerAttr.value)
      stmt.setString(8, bean.commentsAttr.value)
      stmt.setString(9, bean.actionAttr.value)
      stmt.setString(10, bean.pathAttr.value)
      stmt.setString(11, bean.fileNameAttr.value)
      stmt.setString(12, bean.commitYmdAttr.value)
      stmt.setString(13, bean.commitHmsAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  def insert(conn: Connection, list: util.ArrayList[TrCommitHistoryBean]): Int  = {
    var _list: List[TrCommitHistoryBean] = List()

    for (i <- 0 until list.size) {
      _list ::= list.get(i)
    }

    val result: Int = insert(conn, _list)

    result
  }

  /**
   * == update ==
   *
   * it updates TR_COMMIT_HISTORY using list of TrCommitHistoryBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of TrCommitHistoryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[TrCommitHistoryBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/UPDATE_TR_COMMIT_HISTORY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: TrCommitHistoryBean =>
      stmt.setString(1,  bean.repositoryKindAttr.value)
      stmt.setString(2,  bean.repositoryNameAttr.value)
      stmt.setString(3,  bean.rootUrlAttr.value)
      stmt.setString(4,  bean.rightBaseUrlAttr.value)
      stmt.setString(5,  bean.leftBaseUrlAttr.value)
      stmt.setBigDecimal(6, bean.revisionAttr.value)
      stmt.setString(7,  bean.committerAttr.value)
      stmt.setString(8,  bean.commentsAttr.value)
      stmt.setString(9,  bean.actionAttr.value)
      stmt.setString(10, bean.pathAttr.value)
      stmt.setString(11, bean.fileNameAttr.value)
      stmt.setString(12, bean.commitYmdAttr.value)
      stmt.setString(13, bean.commitHmsAttr.value)

      stmt.setString(14, bean.repositoryNameAttr.value)
      stmt.setString(15, bean.rootUrlAttr.value)
      stmt.setString(16, bean.rightBaseUrlAttr.value)
      stmt.setString(17, bean.leftBaseUrlAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes TR_COMMIT_HISTORY by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean TrCommitHistoryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: TrCommitHistoryBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_TR_COMMIT_HISTORY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.repositoryNameAttr.value)
    stmt.setString(2, bean.rootUrlAttr.value)
    stmt.setString(3, bean.rightBaseUrlAttr.value)
    stmt.setString(4, bean.leftBaseUrlAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes TR_COMMIT_HISTORY by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def deleteAll(conn: Connection): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/DELETE_TR_COMMIT_HISTORY_ALL.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to TR_COMMIT_HISTORY using a TrCommitHistoryBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean TrCommitHistoryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: TrCommitHistoryBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/src/mainte/tool/MERGE_TR_COMMIT_HISTORY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}