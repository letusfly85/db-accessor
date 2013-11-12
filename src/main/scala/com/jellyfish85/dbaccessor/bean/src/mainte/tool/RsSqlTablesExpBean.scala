package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RsSqlTablesExpBean extends GeneralBean with RsSqlTablesBeanTrait {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SQL_TABLES_EXP"

  var subLineAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
}