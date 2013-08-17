package com.jellyfish85.dbaccessor.erd.mainte.tool.bean

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class MsTabColumnsBean extends GeneralBean {

  val logicalTableName:  String =  "カラムマスタ"
  val physicalTableName: String =  "MS_TAB_COLUMNS"

  var	tabDefIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	authourAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	updatorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	logicalTableTagAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	logicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	physicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	tableCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	logicalColumnTagAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	logicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	physicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	columnCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataLengthAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataPrecisionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataDefaultAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataScaleAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	pkFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	nullableAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	segoseiCheckStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	segoseiCheckLogIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	ticketNumberAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()

}
