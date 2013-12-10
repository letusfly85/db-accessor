package com.jellyfish85.dbaccessor.dao.query.generate.tool

import com.jellyfish85.dbaccessor.dao.GeneralDao
import java.sql.{SQLException, ResultSet, PreparedStatement, Connection}
import com.jellyfish85.dbaccessor.bean.query.generate.tool.KrObjectDependenciesBean

/**
 * == KrObjectDependenciesDao ==
 *
 */
class KrObjectDependenciesDao extends GeneralDao[KrObjectDependenciesBean] {
  /**
   * == find ==
   *
   * it searches KR_OBJECT_DEPENDENCIES by primary keys, and returns list of KrObjectDependenciesBean
   *
   *
   * @param conn JDBC Connection
   * @param bean KrObjectDependenciesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_OBJECT_DEPENDENCIES
   */
  @throws(classOf[SQLException])
  def find(conn: Connection,   bean: KrObjectDependenciesBean): List[KrObjectDependenciesBean] = {
    var list: List[KrObjectDependenciesBean] = List()

    val sql:  String = generateSimpleQuery("/query/query/generate/tool/SELECT_KR_OBJECT_DEPENDENCIES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.dependentGrpCdAttr.value)
    stmt.setString(2, bean.dependentCdAttr.value)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrObjectDependenciesBean = new KrObjectDependenciesBean

      bean.dependentGrpCdAttr.value = result.getString("DEPENDENT_GRP_CD")
      bean.dependentCdAttr.value = result.getString("DEPENDENT_CD")
      bean.refferedOwnerAttr.value = result.getString("REFFERED_OWNER")
      bean.objectOwnerAttr.value = result.getString("OBJECT_OWNER")
      bean.backupOwnerAttr.value = result.getString("BACKUP_OWNER")
      bean.ifFlgAttr.value = result.getString("IF_FLG")
      bean.masterDataCheckFlgAttr.value = result.getString("MASTER_DATA_CHECK_FLG")
      
      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == findByDependencyCd ==
   *
   * it searches KR_OBJECT_DEPENDENCIES by primary keys, and returns list of KrObjectDependenciesBean
   *
   *
   * @param conn JDBC Connection
   * @param dependentGrpCd dependentGrpCd
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return list of KR_OBJECT_DEPENDENCIES
   */
  @throws(classOf[SQLException])
  def findByDependencyGrpCd(conn: Connection,   dependentGrpCd: String): List[KrObjectDependenciesBean] = {
    var list: List[KrObjectDependenciesBean] = List()

    val sql:  String = generateSimpleQuery("/query/query/generate/tool/SELECT_KR_OBJECT_DEPENDENCIES_BY_DEPENDENCY_GRP_CD.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, dependentGrpCd)

    val result: ResultSet = stmt.executeQuery()
    while (result.next()) {
      val bean: KrObjectDependenciesBean = new KrObjectDependenciesBean

      bean.dependentGrpCdAttr.value = result.getString("DEPENDENT_GRP_CD")
      bean.dependentCdAttr.value = result.getString("DEPENDENT_CD")
      bean.refferedOwnerAttr.value = result.getString("REFFERED_OWNER")
      bean.objectOwnerAttr.value = result.getString("OBJECT_OWNER")
      bean.backupOwnerAttr.value = result.getString("BACKUP_OWNER")
      bean.ifFlgAttr.value = result.getString("IF_FLG")
      bean.masterDataCheckFlgAttr.value = result.getString("MASTER_DATA_CHECK_FLG")

      list ::= bean
    }
    stmt.close()

    list
  }

  /**
   * == insert ==
   *
   * it inserts to KR_OBJECT_DEPENDENCIES using list of KrObjectDependenciesBean, and returns a number of inserted records.
   *
   * @param conn JDBC Connection
   * @param list list of KrObjectDependenciesBean
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def insert(conn: Connection, list: List[KrObjectDependenciesBean]): Int  = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/INSERT_KR_OBJECT_DEPENDENCIES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrObjectDependenciesBean =>
      stmt.setString(1, bean.dependentGrpCdAttr.value)
      stmt.setString(2, bean.dependentCdAttr.value)
      stmt.setString(3, bean.refferedOwnerAttr.value)
      stmt.setString(4, bean.objectOwnerAttr.value)
      stmt.setString(5, bean.backupOwnerAttr.value)
      stmt.setString(6, bean.ifFlgAttr.value)
      stmt.setString(7, bean.masterDataCheckFlgAttr.value)
    
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == update ==
   *
   * it updates KR_OBJECT_DEPENDENCIES using list of KrObjectDependenciesBean, and returns a number of updated records.
   *
   * @param conn JDBC Connection
   * @param list list of KrObjectDependenciesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def update(conn: Connection, list: List[KrObjectDependenciesBean]): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/UPDATE_KR_OBJECT_DEPENDENCIES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    list.foreach {bean: KrObjectDependenciesBean =>
      stmt.setString(1, bean.dependentGrpCdAttr.value)
      stmt.setString(2, bean.dependentCdAttr.value)
      stmt.setString(3, bean.refferedOwnerAttr.value)
      stmt.setString(4, bean.objectOwnerAttr.value)
      stmt.setString(5, bean.backupOwnerAttr.value)
      stmt.setString(6, bean.ifFlgAttr.value)
      stmt.setString(7, bean.masterDataCheckFlgAttr.value)

      stmt.setString(8, bean.dependentGrpCdAttr.value)
      stmt.setString(9, bean.dependentCdAttr.value)
      
      stmt.addBatch()
    }

    result = stmt.executeBatch().size
    stmt.close()

    result
  }

  /**
   * == delete ==
   *
   * it deletes KR_OBJECT_DEPENDENCIES by primary keys, and returns a number of deleted records.
   *
   * @param conn JDBC Connection
   * @param bean KrObjectDependenciesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   */
  @throws(classOf[SQLException])
  def delete(conn: Connection, bean: KrObjectDependenciesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/DELETE_KR_OBJECT_DEPENDENCIES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    stmt.setString(1, bean.dependentGrpCdAttr.value)
    stmt.setString(2, bean.dependentCdAttr.value)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }

  /**
   * == merge ==
   *
   * it merge to KR_OBJECT_DEPENDENCIES using a KrObjectDependenciesBean, and returns a number of merged records.
   *
   * @param  conn JDBC Connection
   * @param  bean KrObjectDependenciesBean
   * @throws java.sql.SQLException, which will be caught outside of itself.
   * @return result which is the number of executed records
   * @deprecated there is no necessary to use merge for this class.
   */
  @throws(classOf[SQLException])
  def merge(conn: Connection,  bean: KrObjectDependenciesBean): Int = {
    var result: Int = 0

    val sql: String = generateSimpleQuery("/query/query/generate/tool/MERGE_KR_OBJECT_DEPENDENCIES.sql")
    val stmt: PreparedStatement = conn.prepareStatement(sql)

    result = stmt.executeUpdate()
    stmt.close()

    result
  }
}