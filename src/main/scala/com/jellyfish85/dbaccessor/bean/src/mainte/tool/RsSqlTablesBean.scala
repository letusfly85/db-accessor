package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

trait RsSqlTablesBeanTrait {

  var headRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var projectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var persisterNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableAliasAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var callTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var crudTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var depthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var extensionAttr:	ColumnAttribute[String] = new ColumnAttribute()

}

class RsSqlTablesBean  extends GeneralBean with RsSqlTablesBeanTrait {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SQL_TABLES"

}