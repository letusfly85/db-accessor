package com.jellyfish85.dbaccessor.dao.query.generate.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.query.generate.tool.KrReleaseDiffsBean

/**
 * == KrReleaseDiffsDao ==
 *
 */
class KrReleaseDiffsDao extends GeneralDao[KrReleaseDiffsBean] {
  /**
   * == find ==
   *
   * it searches KR_RELEASE_DIFFS by primary keys, and returns list of KrReleaseDiffsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_RELEASE_DIFFS
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: KrReleaseDiffsBean): List[KrReleaseDiffsBean] = {
    var list: List[KrReleaseDiffsBean] = List()

    val sql:  String = generateSimpleQuery("/query/query/generate/tool/SELECT_KR_RELEASE_DIFFS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.tagNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrReleaseDiffsBean = new KrReleaseDiffsBean

      bean.tagNameAttr.value = result.getString("TAG_NAME")
      bean.fromRevisionAttr.value = result.getBigDecimal("FROM_REVISION")
      bean.toRevisionAttr.value = result.getBigDecimal("TO_REVISION")
      bean.headerFlgAttr.value = result.getString("HEADER_FLG")
      bean.targetEnvNameAttr.value = result.getString("TARGET_ENV_NAME")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == find ==
   *
   * it searches KR_RELEASE_DIFFS by primary keys, and returns list of KrReleaseDiffsBean
   *
   *
   * @param conn JDBC Connection
   * @param bean KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_RELEASE_DIFFS
   */
  @throws(classOf[SQLException])
  def findByToRevision(conn: Connection,   bean: KrReleaseDiffsBean): List[KrReleaseDiffsBean] = {
    var list: List[KrReleaseDiffsBean] = List()

    val sql:  String = generateSimpleQuery("/query/query/generate/tool/SELECT_KR_RELEASE_DIFFS_BY_TO_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.tagNameAttr.value)
    stmt.setBigDecimal(2, bean.toRevisionAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrReleaseDiffsBean = new KrReleaseDiffsBean

      bean.tagNameAttr.value = result.getString("TAG_NAME")
      bean.fromRevisionAttr.value = result.getBigDecimal("FROM_REVISION")
      bean.toRevisionAttr.value = result.getBigDecimal("TO_REVISION")
      bean.headerFlgAttr.value = result.getString("HEADER_FLG")
      bean.targetEnvNameAttr.value = result.getString("TARGET_ENV_NAME")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to KR_RELEASE_DIFFS using list of KrReleaseDiffsBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of KrReleaseDiffsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[KrReleaseDiffsBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/INSERT_KR_RELEASE_DIFFS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrReleaseDiffsBean =>
      stmt.setString(1, bean.tagNameAttr.value)
      stmt.setBigDecimal(2, bean.fromRevisionAttr.value)
      stmt.setBigDecimal(3, bean.toRevisionAttr.value)
      stmt.setString(4, bean.headerFlgAttr.value)
      stmt.setString(5, bean.targetEnvNameAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_RELEASE_DIFFS using list of KrReleaseDiffsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[KrReleaseDiffsBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/UPDATE_KR_RELEASE_DIFFS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrReleaseDiffsBean =>
      stmt.setString(1, bean.tagNameAttr.value)
      stmt.setBigDecimal(2, bean.fromRevisionAttr.value)
      stmt.setBigDecimal(3, bean.toRevisionAttr.value)
      stmt.setString(4, bean.headerFlgAttr.value)
      stmt.setString(5, bean.targetEnvNameAttr.value)

      stmt.setString(6, bean.tagNameAttr.value)
      stmt.setBigDecimal(7, bean.toRevisionAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_RELEASE_DIFFS using list of KrReleaseDiffsBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param bean bean of KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, bean: KrReleaseDiffsBean): Int = {
    var result: Int = 0
    result = update(conn, List(bean))

    result
  }

  /**
   * == delete ==
   *
   * it deletes KR_RELEASE_DIFFS by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use delete for this class.
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: KrReleaseDiffsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/DELETE_KR_RELEASE_DIFFS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to KR_RELEASE_DIFFS using a KrReleaseDiffsBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean KrReleaseDiffsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: KrReleaseDiffsBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/MERGE_KR_RELEASE_DIFFS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}