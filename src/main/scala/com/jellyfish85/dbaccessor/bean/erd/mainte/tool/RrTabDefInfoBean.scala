package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RrTabDefInfoBean extends GeneralBean {

  val logicalTableName:  String =  "テーブル定義情報履歴"
  val physicalTableName: String =  "RR_TAB_DEF_INFO"

  var tabDefIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tabDefNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tabDefRevisionAfAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tabDefRevisionBfAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var svnRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authourAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var updatorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var logicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var physicalTableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var logicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var physicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var columnCommentAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataLengthAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataPrecisionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataScaleAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pkFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var nullableAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataDefaultAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var segoseiCheckStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var segoseiCheckLogIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()

}