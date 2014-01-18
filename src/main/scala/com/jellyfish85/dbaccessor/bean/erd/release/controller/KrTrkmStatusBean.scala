package com.jellyfish85.dbaccessor.bean.erd.release.controller

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class KrTrkmStatusBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "KR_TRKM_STATUS"

  var trkmIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var currentFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var trkmYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var trkmHhmissAttr:	ColumnAttribute[String] = new ColumnAttribute()

}