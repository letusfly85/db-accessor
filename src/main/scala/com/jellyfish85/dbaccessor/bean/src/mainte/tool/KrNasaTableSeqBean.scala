package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class KrNasaTableSeqBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "KR_NASA_TABLE_SEQ"

  var tableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var currentIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var previousIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()

}