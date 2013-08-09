package com.jellyfish85.dbaccessor.erd.mainte.tool.bean

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}

class MsTablesBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  ""

  var	trkmIdAttr:	ColumnAttribute[Int] = new ColumnAttribute()
  var	tabDefIdAttr:	ColumnAttribute[Int] = new ColumnAttribute()
  var	tableIdAttr:	ColumnAttribute[Int] = new ColumnAttribute()
  var	revisionAttr:	ColumnAttribute[Int] = new ColumnAttribute()
  var	logicalTableTagAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	logicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	physicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	tableCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	segoseiCheckStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	ticketNumberAttr:	ColumnAttribute[Int] = new ColumnAttribute()
  var	existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()

}
