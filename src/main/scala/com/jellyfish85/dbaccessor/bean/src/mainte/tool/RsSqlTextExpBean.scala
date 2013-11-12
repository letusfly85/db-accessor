package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RsSqlTextExpBean extends GeneralBean with RsSqlTextBeanTrait {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SQL_TEXT_EXP"

  var subLineAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()

}