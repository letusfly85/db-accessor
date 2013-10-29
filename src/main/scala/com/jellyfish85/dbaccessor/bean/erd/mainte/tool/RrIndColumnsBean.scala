package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RrIndColumnsBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RR_IND_COLUMNS"

  var indexNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAfAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var revisionBfAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var columnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var columnPositionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()

}