package com.jellyfish85.dbaccessor.scaffold.bean

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}

/**
 * == ALL_TAB_COLUMNS ==
 *
 * ALL_TAB_COLUMNS describes the columns of the tables, views, and clusters accessible to the current user.
 * To gather statistics for this view, use the ANALYZE SQL statement or the DBMS_STATS package.
 *
 */
class AllTabColumnsBean extends GeneralBean {
  val logicalTableName:  String =  "ALL_TAB_COLUMNS"
  val physicalTableName: String =  "ALL_TAB_COLUMNS"

  var	ownerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	tableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	columnNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataTypeModAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataTypeOwnerAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataLengthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	dataPrecisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	dataScaleAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	nullableAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	columnIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	defaultLengthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	dataDefaultAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	numDistinctAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	lowValueAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	highValueAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	densityAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	numNullsAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	numBucketsAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	lastAnalyzedAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	sampleSizeAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	characterSetNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	charColDeclLengthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	globalStatsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	userStatsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	avgColLenAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	charLengthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var	charUsedAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	v80FmtImageAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	dataUpgradedAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var	histogramAttr:	ColumnAttribute[String] = new ColumnAttribute()

}
