package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsErdReleasesBean

import java.math.BigDecimal
import java.util

/**
 * == MsErdReleasesDao ==
 *
 */
class MsErdReleasesDao extends GeneralDao[MsErdReleasesBean] {
  /**
   * == find ==
   *
   * it searches MS_ERD_RELEASES by primary keys, and returns list of MsErdReleasesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean MsErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_ERD_RELEASES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: MsErdReleasesBean): List[MsErdReleasesBean] = {
    var list: List[MsErdReleasesBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.objectNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: MsErdReleasesBean = new MsErdReleasesBean

      bean.releaseIdAttr.value = result.getBigDecimal("RELEASE_ID")
      bean.objectTypeAttr.value = result.getString("OBJECT_TYPE")
      bean.objectIdAttr.value = result.getBigDecimal("OBJECT_ID")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.objectNameAttr.value = result.getString("OBJECT_NAME")
      bean.diffTypeAttr.value = result.getString("DIFF_TYPE")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findMaxReleaseId ==
   *
   * it searches MS_ERD_RELEASES by primary keys, and returns list of MsErdReleasesBean
   *
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_ERD_RELEASES
   */
  @throws(classOf[SQLException])
  def findMaxReleaseId(conn: Connection): BigDecimal = {
    var maxReleaseId: BigDecimal = null

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_ERD_RELEASES_MAX_RELEASE_ID.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      maxReleaseId = result.getBigDecimal("RELEASE_ID")
    }
    stmt.close()

    maxReleaseId
  }

  /**
   * == findTargetFromTemporary ==
   *
   * it searches MS_ERD_RELEASES by primary keys, and returns list of MsErdReleasesBean
   *
   *
   * @param conn JDBC Connection
   * @param releaseId
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_ERD_RELEASES
   * @todo   test
   */
  @throws(classOf[SQLException])
  def findTargetFromTemporary(conn: Connection, releaseId: BigDecimal): List[MsErdReleasesBean] = {
    var list: List[MsErdReleasesBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_ERD_RELEASES_FROM_TEMPORARY_RELEASE.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, releaseId)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: MsErdReleasesBean = new MsErdReleasesBean

      bean.releaseIdAttr.value = result.getBigDecimal("RELEASE_ID")
      bean.objectTypeAttr.value = result.getString("OBJECT_TYPE")
      bean.objectIdAttr.value = result.getBigDecimal("OBJECT_ID")
      bean.revisionAttr.value = result.getBigDecimal("REVISION")
      bean.objectNameAttr.value = result.getString("OBJECT_NAME")
      bean.diffTypeAttr.value = result.getString("DIFF_TYPE")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of MsErdReleasesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[MsErdReleasesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsErdReleasesBean =>
      stmt.setBigDecimal(1, bean.releaseIdAttr.value)
      stmt.setString(2, bean.objectTypeAttr.value)
      stmt.setBigDecimal(3, bean.objectIdAttr.value)
      stmt.setBigDecimal(4, bean.revisionAttr.value)
      stmt.setString(5, bean.objectNameAttr.value)
      stmt.setString(6, bean.diffTypeAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == insert ==
   *
   * it inserts to MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of MsErdReleasesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: util.ArrayList[MsErdReleasesBean]): Int  = {
    var _list: List[MsErdReleasesBean] = List()

    for (i <- 0 until list.size()) {bean: MsErdReleasesBean =>
      _list ::= list.get(i)
    }

    insert(conn, _list)
  }

  /**
   * == insert ==
   *
   * it inserts to MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param releaseId
   * @return result which is the number of executed records
   * @todo   test
   */
  @throws(classOf[SQLException])
  def insertFromHst(conn: Connection, releaseId: BigDecimal): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_ERD_REELASES_FROM_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, releaseId)
    stmt.setBigDecimal(2, releaseId)
    stmt.setBigDecimal(3, releaseId)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of MsErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[MsErdReleasesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsErdReleasesBean =>
      stmt.setBigDecimal(1, bean.releaseIdAttr.value)
      stmt.setString(2, bean.objectTypeAttr.value)
      stmt.setBigDecimal(3, bean.objectIdAttr.value)
      stmt.setBigDecimal(4, bean.revisionAttr.value)
      stmt.setString(5, bean.objectNameAttr.value)
      stmt.setString(6, bean.diffTypeAttr.value)

      stmt.setString(7, bean.objectNameAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes MS_ERD_RELEASES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean MsErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: MsErdReleasesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.objectNameAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == deleteAll ==
   *
   * it deletes MS_ERD_RELEASES all, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def deleteAll(conn: Connection): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_ERD_RELEASES_ALL.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to MS_ERD_RELEASES using a MsErdReleasesBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean MsErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: MsErdReleasesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}