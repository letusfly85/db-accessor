package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

/**
 * == VChangesetsBean ==
 *
 * store history of subversion changes through a Redmine project
 *
 */
class VChangesetsBean extends GeneralBean {

  val logicalTableName:  String =  "history of changes in redmine"
  val physicalTableName: String =  "V_CHANGESETS"

  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var committerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commentsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var actionAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitDateAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()

}