package com.jellyfish85.dbaccessor.erd.mainte.tool.bean

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class MsIndexesBean extends GeneralBean {

  val logicalTableName:  String =  "インデックスマスタ"
  val physicalTableName: String =  "MS_INDEXES"

  var	indexNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	tabDefIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	ticketNumberAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	uniquenessAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	functionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	bitmapAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	reverseAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	keyCompressAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	commitFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	functionFomulaAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	localityAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	partitionedAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	statusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	pkIndexFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()

}
