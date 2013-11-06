package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal
import com.jellyfish85.dbaccessor.src.mainte.tool.RsSvnSrcInfoBean

class RsSqlCdataBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SQL_CDATA"

  var headRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var projectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var persisterNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var lineAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var textAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var extensionAttr:	ColumnAttribute[String] = new ColumnAttribute()

}