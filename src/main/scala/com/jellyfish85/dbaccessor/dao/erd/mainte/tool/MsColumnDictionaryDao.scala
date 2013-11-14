package com.jellyfish85.dbaccessor.dao.erd.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.erd.mainte.tool.MsColumnDictionaryBean

/**
 * == MsColumnDictionaryDao ==
 *
 */
class MsColumnDictionaryDao extends GeneralDao[MsColumnDictionaryBean] {
  /**
   * == find ==
   *
   * it searches MS_COLUMN_DICTIONARY by primary keys, and returns list of MsColumnDictionaryBean
   *
   *
   * @param conn JDBC Connection
   * @param bean MsColumnDictionaryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of MS_COLUMN_DICTIONARY
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: MsColumnDictionaryBean): List[MsColumnDictionaryBean] = {
    var list: List[MsColumnDictionaryBean] = List()

    val sql:  String = generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_COLUMN_DICTIONARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.physicalColumnNameAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: MsColumnDictionaryBean = new MsColumnDictionaryBean

      bean.dictColumnIdAttr.value = result.getBigDecimal("DICT_COLUMN_ID")
      bean.physicalColumnNameAttr.value = result.getString("PHYSICAL_COLUMN_NAME")
      bean.dataTypeAttr.value = result.getString("DATA_TYPE")
      bean.dataLengthAttr.value = result.getString("DATA_LENGTH")
      bean.dataPrecisionAttr.value = result.getString("DATA_PRECISION")
      bean.dataDefaultAttr.value = result.getString("DATA_DEFAULT")
      bean.entityFieldNameAttr.value = result.getString("ENTITY_FIELD_NAME")
      bean.entityFieldTypeAttr.value = result.getString("ENTITY_FIELD_TYPE")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to MS_COLUMN_DICTIONARY using list of MsColumnDictionaryBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of MsColumnDictionaryBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[MsColumnDictionaryBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/INSERT_MS_COLUMN_DICTIONARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsColumnDictionaryBean =>
      stmt.setBigDecimal(1, bean.dictColumnIdAttr.value)
      stmt.setString(2, bean.physicalColumnNameAttr.value)
      stmt.setString(3, bean.dataTypeAttr.value)
      stmt.setString(4, bean.dataLengthAttr.value)
      stmt.setString(5, bean.dataPrecisionAttr.value)
      stmt.setString(6, bean.dataDefaultAttr.value)
      stmt.setString(7, bean.entityFieldNameAttr.value)
      stmt.setString(8, bean.entityFieldTypeAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates MS_COLUMN_DICTIONARY using list of MsColumnDictionaryBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of MsColumnDictionaryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[MsColumnDictionaryBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/UPDATE_MS_COLUMN_DICTIONARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: MsColumnDictionaryBean =>
      stmt.setBigDecimal(1, bean.dictColumnIdAttr.value)
      stmt.setString(2, bean.physicalColumnNameAttr.value)
      stmt.setString(3, bean.dataTypeAttr.value)
      stmt.setString(4, bean.dataLengthAttr.value)
      stmt.setString(5, bean.dataPrecisionAttr.value)
      stmt.setString(6, bean.dataDefaultAttr.value)
      stmt.setString(7, bean.entityFieldNameAttr.value)
      stmt.setString(8, bean.entityFieldTypeAttr.value)

      stmt.setString(9, bean.physicalColumnNameAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes MS_COLUMN_DICTIONARY by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean MsColumnDictionaryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: MsColumnDictionaryBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/DELETE_MS_COLUMN_DICTIONARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.physicalColumnNameAttr.value)
    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to MS_COLUMN_DICTIONARY using a MsColumnDictionaryBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean MsColumnDictionaryBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   *
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: MsColumnDictionaryBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/erd/mainte/tool/MERGE_MS_COLUMN_DICTIONARY.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.physicalColumnNameAttr.value)

    stmt.setBigDecimal(2, bean.dictColumnIdAttr.value)
    stmt.setString(3, bean.dataTypeAttr.value)
    stmt.setString(4, bean.dataLengthAttr.value)
    stmt.setString(5, bean.dataPrecisionAttr.value)
    stmt.setString(6, bean.dataDefaultAttr.value)
    stmt.setString(7, bean.entityFieldNameAttr.value)
    stmt.setString(8, bean.entityFieldTypeAttr.value)

    stmt.setBigDecimal(9, bean.dictColumnIdAttr.value)
    stmt.setString(10, bean.physicalColumnNameAttr.value)
    stmt.setString(11, bean.dataTypeAttr.value)
    stmt.setString(12, bean.dataLengthAttr.value)
    stmt.setString(13, bean.dataPrecisionAttr.value)
    stmt.setString(14, bean.dataDefaultAttr.value)
    stmt.setString(15, bean.entityFieldNameAttr.value)
    stmt.setString(16, bean.entityFieldTypeAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}