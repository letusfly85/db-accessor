package com.jellyfish85.dbaccessor.bean.erd.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

/**
 * == KrTabDefRevisionBean ==
 *
 * administrate table define books revisions
 * polling job insert, update to this table.
 *
 *
 */
class KrTabDefRevisionBean extends GeneralBean {

  val logicalTableName:  String =  "テーブル定義書リビジョン管理"
  val physicalTableName: String =  "KR_TAB_DEF_REVISION"

  var tabDefIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tabDefRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var tabDefNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var lastUpdateYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var lastUpdateHhmissAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var updateFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var newFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var svnRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var svnPathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var existsFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var trkmStatusAttr:	ColumnAttribute[String] = new ColumnAttribute()

}