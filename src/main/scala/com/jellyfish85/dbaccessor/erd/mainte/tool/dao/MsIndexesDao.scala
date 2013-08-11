package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.MsIndexesBean
import java.sql.Connection

class MsIndexesDao extends GeneralDao[MsIndexesBean] {

  def find(conn: Connection,   bean: MsIndexesBean): List[MsIndexesBean] = {
    var list: List[MsIndexesBean] = List()

    list
  }

  def insert(conn: Connection, bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

  def update(conn: Connection, bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

  def merge(conn: Connection,  bean: MsIndexesBean): Int = {
    val result: Int = 0

    result
  }

}
