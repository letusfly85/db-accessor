package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class MsTablesBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "MS_TABLES"

  var trkmIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tabDefIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var serviceNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var systemNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var subsystemNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var logicalTableTagAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var logicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var physicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var segoseiCheckStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var ticketNumberAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()


}
