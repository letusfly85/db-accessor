package com.jellyfish85.dbaccessor.scaffold.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.scaffold.bean.AllTabColumnsBean
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}

/**
 *
 *
 */
class AllTabColumnsDao extends GeneralDao[AllTabColumnsBean] {
  /**
   *
   * @param conn JDBC Connection
   * @param bean AllTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of AllTabColumns
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: AllTabColumnsBean): List[AllTabColumnsBean] = {
    var list: List[AllTabColumnsBean] = List()

    val sql:  String = generateSimpleQuery("/query/scaffold/SELECT_ALL_TAB_COLUMNS.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.ownerAttr.value)
    stmt.setString(2, bean.tableNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: AllTabColumnsBean = new AllTabColumnsBean

      bean.ownerAttr.value = result.getString("OWNER")
      bean.tableNameAttr.value = result.getString("TABLE_NAME")
      bean.columnNameAttr.value = result.getString("COLUMN_NAME")
      bean.dataTypeAttr.value = result.getString("DATA_TYPE")
      bean.dataTypeModAttr.value = result.getString("DATA_TYPE_MOD")
      bean.dataTypeOwnerAttr.value = result.getString("DATA_TYPE_OWNER")
      bean.dataLengthAttr.value = result.getBigDecimal("DATA_LENGTH")
      bean.dataPrecisionAttr.value = result.getBigDecimal("DATA_PRECISION")
      bean.dataScaleAttr.value = result.getBigDecimal("DATA_SCALE")
      bean.nullableAttr.value = result.getString("NULLABLE")
      bean.columnIdAttr.value = result.getBigDecimal("COLUMN_ID")
      bean.defaultLengthAttr.value = result.getBigDecimal("DEFAULT_LENGTH")
      bean.dataDefaultAttr.value = result.getBigDecimal("DATA_DEFAULT")
      bean.numDistinctAttr.value = result.getBigDecimal("NUM_DISTINCT")
      bean.lowValueAttr.value = result.getBigDecimal("LOW_VALUE")
      bean.highValueAttr.value = result.getBigDecimal("HIGH_VALUE")
      bean.densityAttr.value = result.getBigDecimal("DENSITY")
      bean.numNullsAttr.value = result.getBigDecimal("NUM_NULLS")
      bean.numBucketsAttr.value = result.getBigDecimal("NUM_BUCKETS")
      bean.lastAnalyzedAttr.value = result.getBigDecimal("LAST_ANALYZED")
      bean.sampleSizeAttr.value = result.getBigDecimal("SAMPLE_SIZE")
      bean.characterSetNameAttr.value = result.getString("CHARACTER_SET_NAME")
      bean.charColDeclLengthAttr.value = result.getBigDecimal("CHAR_COL_DECL_LENGTH")
      bean.globalStatsAttr.value = result.getString("GLOBAL_STATS")
      bean.userStatsAttr.value = result.getString("USER_STATS")
      bean.avgColLenAttr.value = result.getBigDecimal("AVG_COL_LEN")
      bean.charLengthAttr.value = result.getBigDecimal("CHAR_LENGTH")
      bean.charUsedAttr.value = result.getString("CHAR_USED")
      bean.v80FmtImageAttr.value = result.getString("V80_FMT_IMAGE")
      bean.dataUpgradedAttr.value = result.getString("DATA_UPGRADED")
      bean.histogramAttr.value = result.getString("HISTOGRAM")

      list ::= bean
    }

    list
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of AllTabColumnsBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[AllTabColumnsBean]): Int  = {
    val result: Int = 0

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param list list of AllTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[AllTabColumnsBean]): Int = {
    val result: Int = 0

    result
  }

  /**
   *
   *
   * @param conn JDBC Connection
   * @param bean AllTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: AllTabColumnsBean): Int = {
    val result: Int = 0

    result
  }

  /**
   *
   * @param  conn JDBC Connection
   * @param  bean AllTabColumnsBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: AllTabColumnsBean): Int = {
    val result: Int = 0

    result
  }

}
