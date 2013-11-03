package com.jellyfish85.dbaccessor.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RsSvnSrcInfoBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SVN_SRC_INFO"

  var headRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var projectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var extensionAttr:	ColumnAttribute[String] = new ColumnAttribute()

}