package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RsConfigAttributesBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_CONFIG_ATTRIBUTES"

  var headRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var projectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var actionNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var subjectIdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fromIdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var toIdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var nextActionNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var extensionAttr:	ColumnAttribute[String] = new ColumnAttribute()

}