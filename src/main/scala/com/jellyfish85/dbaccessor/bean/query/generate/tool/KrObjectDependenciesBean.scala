package com.jellyfish85.dbaccessor.bean.query.generate.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class KrObjectDependenciesBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "KR_OBJECT_DEPENDENCIES"

  var dependentGrpCdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var dependentCdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var refferedOwnerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var objectOwnerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var backupOwnerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var ifFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var masterDataCheckFlgAttr:	ColumnAttribute[String] = new ColumnAttribute()

  var serviceNameAttr: ColumnAttribute[String] = new ColumnAttribute()
  var systemNameAttr:  ColumnAttribute[String] = new ColumnAttribute()

}