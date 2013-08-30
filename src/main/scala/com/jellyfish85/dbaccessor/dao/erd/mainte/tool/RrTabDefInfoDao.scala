package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.RrTabDefInfoBean

/**
 * == RrTabDefInfoDao ==
 *
 */
class RrTabDefInfoDao extends GeneralDao[RrTabDefInfoBean] {
  /**
   * == find ==
   *
   * @param conn JDBC Connection
   * @param bean RrTabDefInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of RR_TAB_DEF_INFO
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: RrTabDefInfoBean): List[RrTabDefInfoBean] = {
    var list: List[RrTabDefInfoBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELLECT_RR_TAB_DEF_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.tabDefRevisionAfAttr.value)
    stmt.setString(2, bean.tabDefNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RrTabDefInfoBean = new RrTabDefInfoBean

      bean.tabDefIdAttr.value = result.getBigDecimal("TAB_DEF_ID")
      bean.tabDefNameAttr.value = result.getString("TAB_DEF_NAME")
      bean.tabDefRevisionAfAttr.value = result.getBigDecimal("TAB_DEF_REVISION_AF")
      bean.tabDefRevisionBfAttr.value = result.getBigDecimal("TAB_DEF_REVISION_BF")
      bean.svnRevisionAttr.value = result.getBigDecimal("SVN_REVISION")
      bean.authourAttr.value = result.getString("AUTHOUR")
      bean.updatorAttr.value = result.getString("UPDATOR")
      bean.logicalTableNameAttr.value = result.getString("LOGICAL_TABLE_NAME")
      bean.physicalTableNameAttr.value = result.getString("PHYSICAL_TABLE_NAME")
      bean.tableCommentAttr.value = result.getString("TABLE_COMMENT")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.logicalColumnNameAttr.value = result.getString("LOGICAL_COLUMN_NAME")
      bean.physicalColumnNameAttr.value = result.getString("PHYSICAL_COLUMN_NAME")
      bean.columnCommentAttr.value = result.getString("COLUMN_COMMENT")
      bean.dataTypeAttr.value = result.getString("DATA_TYPE")
      bean.dataLengthAttr.value = result.getString("DATA_LENGTH")
      bean.dataPrecisionAttr.value = result.getString("DATA_PRECISION")
      bean.dataScaleAttr.value = result.getString("DATA_SCALE")
      bean.pkFlgAttr.value = result.getString("PK_FLG")
      bean.nullableAttr.value = result.getString("NULLABLE")
      bean.dataDefaultAttr.value = result.getString("DATA_DEFAULT")
      bean.trkmStatusAttr.value = result.getString("TRKM_STATUS")
      bean.segoseiCheckStatusAttr.value = result.getString("SEGOSEI_CHECK_STATUS")
      bean.segoseiCheckLogIdAttr.value = result.getBigDecimal("SEGOSEI_CHECK_LOG_ID")
      bean.existsFlgAttr.value = result.getString("EXISTS_FLG")
      
      list ::= bean
    }

    list
  }

  /**
   * == insert ==
   *
   * @param conn JDBC Connection
   * @param list list of RrTabDefInfoBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[RrTabDefInfoBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_RR_TAB_DEF_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTabDefInfoBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setString(2, bean.tabDefNameAttr.value)
      stmt.setBigDecimal(3, bean.tabDefRevisionAfAttr.value)
      stmt.setBigDecimal(4, bean.tabDefRevisionBfAttr.value)
      stmt.setBigDecimal(5, bean.svnRevisionAttr.value)
      stmt.setString(6, bean.authourAttr.value)
      stmt.setString(7, bean.updatorAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.physicalTableNameAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setBigDecimal(11, bean.columnIdAttr.value)
      stmt.setString(12, bean.logicalColumnNameAttr.value)
      stmt.setString(13, bean.physicalColumnNameAttr.value)
      stmt.setString(14, bean.columnCommentAttr.value)
      stmt.setString(15, bean.dataTypeAttr.value)
      stmt.setString(16, bean.dataLengthAttr.value)
      stmt.setString(17, bean.dataPrecisionAttr.value)
      stmt.setString(18, bean.dataScaleAttr.value)
      stmt.setString(19, bean.pkFlgAttr.value)
      stmt.setString(20, bean.nullableAttr.value)
      stmt.setString(21, bean.dataDefaultAttr.value)
      stmt.setString(22, bean.trkmStatusAttr.value)
      stmt.setString(23, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(24, bean.segoseiCheckLogIdAttr.value)
      stmt.setString(25, bean.existsFlgAttr.value)
    
     stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == update ==
   *
   * @param conn JDBC Connection
   * @param list list of RrTabDefInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[RrTabDefInfoBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_RR_TAB_DEF_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RrTabDefInfoBean =>
      stmt.setBigDecimal(1, bean.tabDefIdAttr.value)
      stmt.setString(2, bean.tabDefNameAttr.value)
      stmt.setBigDecimal(3, bean.tabDefRevisionAfAttr.value)
      stmt.setBigDecimal(4, bean.tabDefRevisionBfAttr.value)
      stmt.setBigDecimal(5, bean.svnRevisionAttr.value)
      stmt.setString(6, bean.authourAttr.value)
      stmt.setString(7, bean.updatorAttr.value)
      stmt.setString(8, bean.logicalTableNameAttr.value)
      stmt.setString(9, bean.physicalTableNameAttr.value)
      stmt.setString(10, bean.tableCommentAttr.value)
      stmt.setBigDecimal(11, bean.columnIdAttr.value)
      stmt.setString(12, bean.logicalColumnNameAttr.value)
      stmt.setString(13, bean.physicalColumnNameAttr.value)
      stmt.setString(14, bean.columnCommentAttr.value)
      stmt.setString(15, bean.dataTypeAttr.value)
      stmt.setString(16, bean.dataLengthAttr.value)
      stmt.setString(17, bean.dataPrecisionAttr.value)
      stmt.setString(18, bean.dataScaleAttr.value)
      stmt.setString(19, bean.pkFlgAttr.value)
      stmt.setString(20, bean.nullableAttr.value)
      stmt.setString(21, bean.dataDefaultAttr.value)
      stmt.setString(22, bean.trkmStatusAttr.value)
      stmt.setString(23, bean.segoseiCheckStatusAttr.value)
      stmt.setBigDecimal(24, bean.segoseiCheckLogIdAttr.value)
      stmt.setString(25, bean.existsFlgAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size

    result
  }

  /**
   * == delete ==
   *
   * @param conn JDBC Connection
   * @param bean RrTabDefInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: RrTabDefInfoBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_RR_TAB_DEF_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setBigDecimal(1, bean.tabDefRevisionAfAttr.value)
    stmt.setString(2, bean.tabDefNameAttr.value)

    result = stmt.executeUpdate()

    result
  }

  /**
   * == merge ==
   *
   * @param  conn JDBC Connection
   * @param  bean RrTabDefInfoBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RrTabDefInfoBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_RR_TAB_DEF_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()

    result
  }
}