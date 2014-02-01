package com.jellyfish85.dbaccessor.bean.query.generate.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class KrReleaseDiffsBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "KR_RELEASE_DIFFS"

  var tagNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fromRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var toRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var headerFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var targetEnvNameAttr:	ColumnAttribute[String] = new ColumnAttribute()

}