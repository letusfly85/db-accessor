package com.jellyfish85.dbaccessor

import com.jellyfish85.dbaccessor.utils.GenerateQuery
import erd.mainte.tool.bean.MsTablesBean
import erd.mainte.tool.dao.MsTablesDao
import manager.DatabaseManager

object Main extends GenerateQuery {

  def main(args :Array[String]) {

    println(generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES.sql"))

    val db: DatabaseManager = new DatabaseManager
    try {
      db.connect

      val dao:  MsTablesDao = new MsTablesDao
      val bean: MsTablesBean = new MsTablesBean
      bean.physicalTableNameAttr.value = "T_KK_KOKYK_KHN"

      val list: List[MsTablesBean] =  dao.find(db.conn, bean)
      list.foreach {b: MsTablesBean => println(b.physicalTableNameAttr.value)}


    } finally {
      db.jClose
    }
  }
}
