package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class RsSubjectidXqlpathIdxBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SUBJECTID_XQLPATH_IDX"

  var subjectIdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var commiterAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var updateFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var newFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()

}