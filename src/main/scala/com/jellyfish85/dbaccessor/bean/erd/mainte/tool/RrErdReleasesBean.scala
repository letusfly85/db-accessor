package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RrErdReleasesBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RR_ERD_RELEASES"

  var afReleaseIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var bfReleaseIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var objectTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var objectIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var objectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var diffTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
}