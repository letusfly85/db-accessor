package com.jellyfish85.dbaccessor.erd.mainte.tool.bean

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}

class MsTablesBean extends GeneralBean {

  val logicalTableName: String = ""
  val physicalTableName: String = "MS_TABLES"

  var	trkmIdAttr:	ColumnAttribute = new ColumnAttribute()
  var	tabDefIdAttr:	ColumnAttribute = new ColumnAttribute()
  var	tableIdAttr:	ColumnAttribute = new ColumnAttribute()
  var	revisionAttr:	ColumnAttribute = new ColumnAttribute()
  var	logicalTableTagAttr:	ColumnAttribute = new ColumnAttribute()
  var	logicalTableNameAttr:	ColumnAttribute = new ColumnAttribute()
  var	physicalTableNameAttr:	ColumnAttribute = new ColumnAttribute()
  var	trkmStatusAttr:	ColumnAttribute = new ColumnAttribute()
  var	tableCommentAttr:	ColumnAttribute = new ColumnAttribute()
  var	segoseiCheckStatusAttr:	ColumnAttribute = new ColumnAttribute()
  var	ticketNumberAttr:	ColumnAttribute = new ColumnAttribute()
  var	existsFlgAttr:	ColumnAttribute = new ColumnAttribute()

}
