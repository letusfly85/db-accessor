package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class TrCommitHistoryBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "TR_COMMIT_HISTORY"

  var repositoryKindAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var repositoryNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var rootUrlAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var rightBaseUrlAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var leftBaseUrlAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var committerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commentsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var actionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()

}