package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class MsIndColumnsBean extends GeneralBean {

  val logicalTableName:  String =  "インデックスカラムマスタ"
  val physicalTableName: String =  "MS_IND_COLUMNS"

  var indexNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tableIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var columnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var columnPositionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()

}