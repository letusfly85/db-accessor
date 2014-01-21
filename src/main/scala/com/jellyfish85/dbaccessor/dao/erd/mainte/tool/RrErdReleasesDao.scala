package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrErdReleasesBean

import java.math.BigDecimal
import java.util

/**
 * == RrErdReleasesDao ==
 *
 */
class RrErdReleasesDao extends GeneralDao[RrErdReleasesBean] {
  /**
   * == find ==
   *
   * it searches RR_ERD_RELEASES by primary keys, and returns list of RrErdReleasesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean RrErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_ERD_RELEASES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrErdReleasesBean): List[RrErdReleasesBean] = {
    var list: List[RrErdReleasesBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.afReleaseIdAttr.value)
    stmt.setString(2, bean.objectTypeAttr.value)
    stmt.setString(3, bean.objectNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrErdReleasesBean = new RrErdReleasesBean

      bean.afReleaseIdAttr.value = result.getBigDecimal("AF_RELEASE_ID")
      bean.bfReleaseIdAttr.value = result.getBigDecimal("BF_RELEASE_ID")
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
   * it inserts to RR_ERD_RELEASES using list of RrErdReleasesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of RrErdReleasesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrErdReleasesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrErdReleasesBean =>
      stmt.setBigDecimal(1, bean.afReleaseIdAttr.value)
      stmt.setBigDecimal(2, bean.bfReleaseIdAttr.value)
      stmt.setString(3, bean.objectTypeAttr.value)
      stmt.setBigDecimal(4, bean.objectIdAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.objectNameAttr.value)
      stmt.setString(7, bean.diffTypeAttr.value)
    
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
  def insert(conn: Connection, list: util.ArrayList[RrErdReleasesBean]): Int  = {
    var _list: List[RrErdReleasesBean] = List()

    for (i <- 0 until list.size()) {bean: RrErdReleasesBean =>
      _list ::= list.get(i)
    }

    insert(conn, _list)
  }

  //INSERT_RR_ERD_RELEASES_FROM_MS_ERD_RELEASES
  /**
   * == insert ==
   *
   * it inserts to MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param releaseId
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insertFromCur(conn: Connection, releaseId: BigDecimal): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_RR_ERD_RELEASES_FROM_MS_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, releaseId)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates RR_ERD_RELEASES using list of RrErdReleasesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of RrErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrErdReleasesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrErdReleasesBean =>
      stmt.setBigDecimal(1, bean.afReleaseIdAttr.value)
      stmt.setBigDecimal(2, bean.bfReleaseIdAttr.value)
      stmt.setString(3, bean.objectTypeAttr.value)
      stmt.setBigDecimal(4, bean.objectIdAttr.value)
      stmt.setBigDecimal(5, bean.revisionAttr.value)
      stmt.setString(6, bean.objectNameAttr.value)
      stmt.setString(7, bean.diffTypeAttr.value)

      stmt.setBigDecimal(8, bean.afReleaseIdAttr.value)
      stmt.setString(9, bean.objectTypeAttr.value)
      stmt.setString(10, bean.objectNameAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }


  /**
   * == updateByReleaseIds ==
   *
   * it updates MS_ERD_RELEASES using list of MsErdReleasesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param setPreReleaseId
   * @param setCurReleaseId
   * @param wherePreReleaseId
   * @param whereCurReleaseId
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def updateByReleaseIds( conn: Connection,
                          setPreReleaseId: BigDecimal,   setCurReleaseId: BigDecimal,
                          wherePreReleaseId: BigDecimal, whereCurReleaseId: BigDecimal
                          ): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_RR_ERD_RELEASES_BY_RELEASE_IDS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, setCurReleaseId)
    stmt.setBigDecimal(2, setPreReleaseId)
    stmt.setBigDecimal(3, whereCurReleaseId)
    stmt.setBigDecimal(4, wherePreReleaseId)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes RR_ERD_RELEASES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean RrErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrErdReleasesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.afReleaseIdAttr.value)
    stmt.setString(2, bean.objectTypeAttr.value)
    stmt.setString(3, bean.objectNameAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to RR_ERD_RELEASES using a RrErdReleasesBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean RrErdReleasesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrErdReleasesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_RR_ERD_RELEASES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}