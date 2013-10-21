package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.KrTabDefRevisionBean

/**
 * == KrTabDefRevisionDao ==
 *
 * insert, update table define books revision using bean.
 *
 */
class KrTabDefRevisionDao extends GeneralDao[KrTabDefRevisionBean] {
  /**
   *
   * @param conn JDBC Connection
   * @param bean KrTabDefRevisionBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_TAB_DEF_REVISION
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: KrTabDefRevisionBean): List[KrTabDefRevisionBean] = {
    var list: List[KrTabDefRevisionBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_KR_TAB_DEF_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.tabDefNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrTabDefRevisionBean = new KrTabDefRevisionBean

      bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
      bean.tabDefRevisionAttr.value = result.getBigDecimal("TAB_DEF_REVISION")
      bean.tabDefNameAttr.value = result.getString("TAB_DEF_NAME")
      bean.lastUpdateYmdAttr.value = result.getString("LAST_UPDATE_YMD")
      bean.lastUpdateHhmissAttr.value = result.getString("LAST_UPDATE_HHMISS")
      bean.updateFlgAttr.value = result.getString("UPDATE_FLG")
      bean.newFlgAttr.value = result.getString("NEW_FLG")
      bean.svnRevisionAttr.value = result.getBigDecimal("SVN_REVISION")
      bean.svnPathAttr.value = result.getString("SVN_PATH")
      bean.existsFlgAttr.value = result.getString("EXISTS_FLG")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      
      list ::= bean
    }

    list
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of KrTabDefRevisionBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[KrTabDefRevisionBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_KR_TAB_DEF_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrTabDefRevisionBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(2, bean.tabDefRevisionAttr.value)
      stmt.setString(3, bean.tabDefNameAttr.value)
      stmt.setString(4, bean.lastUpdateYmdAttr.value)
      stmt.setString(5, bean.lastUpdateHhmissAttr.value)
      stmt.setString(6, bean.updateFlgAttr.value)
      stmt.setString(7, bean.newFlgAttr.value)
      stmt.setBigDecimal(8, bean.svnRevisionAttr.value)
      stmt.setString(9, bean.svnPathAttr.value)
      stmt.setString(10, bean.existsFlgAttr.value)
      stmt.setString(11, bean.trkmStatusAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of KrTabDefRevisionBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[KrTabDefRevisionBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_KR_TAB_DEF_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrTabDefRevisionBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setBigDecimal(2, bean.tabDefRevisionAttr.value)
      stmt.setString(3, bean.tabDefNameAttr.value)
      stmt.setString(4, bean.lastUpdateYmdAttr.value)
      stmt.setString(5, bean.lastUpdateHhmissAttr.value)
      stmt.setString(6, bean.updateFlgAttr.value)
      stmt.setString(7, bean.newFlgAttr.value)
      stmt.setBigDecimal(8, bean.svnRevisionAttr.value)
      stmt.setString(9, bean.svnPathAttr.value)
      stmt.setString(10, bean.existsFlgAttr.value)
      stmt.setString(11, bean.trkmStatusAttr.value)

      stmt.setString(12, bean.tabDefNameAttr.value)

      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param bean KrTabDefRevisionBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: KrTabDefRevisionBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_KR_TAB_DEF_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.tabDefNameAttr.value)

    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * @param  conn JDBC Connection
   * @param  bean KrTabDefRevisionBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   *
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: KrTabDefRevisionBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_KR_TAB_DEF_REVISION.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1,  bean.tabDefNameAttr.value)
    stmt.setBigDecimal(2,  bean.svnRevisionAttr.value)
    stmt.setString(3, bean.lastUpdateYmdAttr.value)
    stmt.setString(4, bean.lastUpdateHhmissAttr.value)
    stmt.setString(5, bean.svnPathAttr.value)
    stmt.setBigDecimal(6, bean.tabDefRevisionAttr.value)

    stmt.setBigDecimal(7, bean.tabDefIdAttr.value)
    stmt.setBigDecimal(8, bean.tabDefRevisionAttr.value)
    stmt.setString(9,  bean.tabDefNameAttr.value)
    stmt.setString(10,  bean.lastUpdateYmdAttr.value)
    stmt.setString(11, bean.lastUpdateHhmissAttr.value)
    stmt.setBigDecimal(12, bean.tabDefRevisionAttr.value)
    stmt.setString(13, bean.svnPathAttr.value)

    result = stmt.executeUpdate()

    result
  }

}