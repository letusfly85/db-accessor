package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class TrErdTabColumnsBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "TR_ERD_TAB_COLUMNS"

  var trkmIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var logicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var physicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dictColumnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var logicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var physicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var columnCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataLengthAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataPrecisionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataDefaultAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var nullableAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pkFlgAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var torokuymdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var torokuhmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var torokuuserAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var kosinymdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var kosinhmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var kosinuserAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var bikoAttr:	ColumnAttribute[String] = new ColumnAttribute()

}