package com.jellyfish85.dbaccessor.dao.src.mainte.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.RsSvnSrcInfoBean

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

    val sql:  String = generateSimpleQuery("/query/TODO/SELECT_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: RsSvnSrcInfoBean = new RsSvnSrcInfoBean

      bean.headRevisionAttr.value = result.getBigDecimal("HEAD_REVISION")
      bean.fileNameAttr.value = result.getString("FILE_NAME")
      bean.pathAttr.value = result.getString("PATH")
      bean.revisionAttr.value = result.getString("REVISION")
      bean.authorAttr.value = result.getString("AUTHOR")
      bean.commitDateAttr.value = result.getString("COMMIT_DATE")
      bean.commitHmsAttr.value = result.getString("COMMIT_HMS")
      bean.extensionAttr.value = result.getString("EXTENSION")
      
      list ::= bean
    }

    list
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

    val sql: String = generateSimpleQuery("/query/TODO/INSERT_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSvnSrcInfoBean =>
      stmt.setBigDecimal(1, bean.headRevisionAttr.value)
      stmt.setString(2, bean.fileNameAttr.value)
      stmt.setString(3, bean.pathAttr.value)
      stmt.setString(4, bean.revisionAttr.value)
      stmt.setString(5, bean.authorAttr.value)
      stmt.setString(6, bean.commitDateAttr.value)
      stmt.setString(7, bean.commitHmsAttr.value)
    
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

    val sql: String = generateSimpleQuery("/query/TODO/UPDATE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: RsSvnSrcInfoBean =>
        stmt.setBigDecimal(1, bean.headRevisionAttr.value)
        stmt.setString(2, bean.fileNameAttr.value)
        stmt.setString(3, bean.pathAttr.value)
        stmt.setString(4, bean.revisionAttr.value)
        stmt.setString(5, bean.authorAttr.value)
        stmt.setString(6, bean.commitDateAttr.value)
        stmt.setString(7, bean.commitHmsAttr.value)
        stmt.setString(8, bean.extensionAttr.value)
      
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

    val sql: String = generateSimpleQuery("/query/TODO/DELETE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
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
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: RsSvnSrcInfoBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/TODO/MERGE_RS_SVN_SRC_INFO.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    //TODO stmt.setMethods
    result = stmt.executeUpdate()

    result
  }
}