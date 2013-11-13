package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

/**
 * == MsColumnDictionaryBean ==
 *
 * store entity relational diagram's consistency information
 * concretely, this table's primary key strict above
 *
 */
class MsColumnDictionaryBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "MS_COLUMN_DICTIONARY"

  var dictColumnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var physicalColumnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataLengthAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataPrecisionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dataDefaultAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var entityFieldNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var entityFieldTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()

}