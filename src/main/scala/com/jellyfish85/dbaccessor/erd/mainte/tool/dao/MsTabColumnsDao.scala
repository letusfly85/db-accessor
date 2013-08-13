package com.jellyfish85.dbaccessor.erd.mainte.tool.dao

import com.jellyfish85.dbaccessor.dao.GeneralDao
import com.jellyfish85.dbaccessor.erd.mainte.tool.bean.{MsTabColumnsBean}
import java.sql.{Connection, SQLException, ResultSet, PreparedStatement}

class MsTabColumnsDao extends GeneralDao[MsTabColumnsBean] {

  def find(conn: Connection,   bean: MsTabColumnsBean): List[MsTabColumnsBean] = {
    var list: List[MsTabColumnsBean] = List()

    list
  }

  def insert(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def update(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def delete(conn: Connection, bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }

  def merge(conn: Connection,  bean: MsTabColumnsBean): Int = {
    var result: Int = 0

    result
  }
}
