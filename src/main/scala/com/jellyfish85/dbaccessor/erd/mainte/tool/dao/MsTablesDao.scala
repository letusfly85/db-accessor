package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsTablesBean

class MsTablesDao extends GeneralDao[MsTablesBean] {

  def find(db: DatabaseManager,   bean: MsTablesBean): List[MsTablesBean] = {
    val list: List[MsTablesBean] = List()

    list
  }

  def insert(db: DatabaseManager, bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def update(db: DatabaseManager, bean: MsTablesBean) : BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def delete(db: DatabaseManager, bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }

  def merge(db: DatabaseManager,  bean: MsTablesBean): BigDecimal = {
    val result: BigDecimal = 0

    result
  }
}
