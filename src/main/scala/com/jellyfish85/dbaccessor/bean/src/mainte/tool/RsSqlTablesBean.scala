package com.jellyfish85.dbaccessor.bean.src.mainte.tool

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

trait RsSqlTablesBeanTrait {

  var headRevisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var projectNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var fileNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var pathAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var persisterNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableNameAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var tableAliasAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var callTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var crudTypeAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var depthAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var revisionAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var authorAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitYmdAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var commitHmsAttr:	ColumnAttribute[String] = new ColumnAttribute()
  var extensionAttr:	ColumnAttribute[String] = new ColumnAttribute()


  def copyAttr(_attr: RsSqlTablesBeanTrait): RsSqlTablesBeanTrait = {

    _attr.headRevisionAttr.setValue(headRevisionAttr.value)
    _attr.projectNameAttr.setValue(projectNameAttr.value)
    _attr.fileNameAttr.setValue(fileNameAttr.value)
    _attr.pathAttr.setValue(pathAttr.value)
    _attr.persisterNameAttr.setValue(persisterNameAttr.value)
    _attr.tableNameAttr.setValue(tableNameAttr.value)
    _attr.tableAliasAttr.setValue(tableAliasAttr.value)
    _attr.callTypeAttr.setValue(callTypeAttr.value)
    _attr.crudTypeAttr.setValue(crudTypeAttr.value)
    _attr.depthAttr.setValue(depthAttr.value)
    _attr.revisionAttr.setValue(revisionAttr.value)
    _attr.authorAttr.setValue(authorAttr.value)
    _attr.commitYmdAttr.setValue(commitYmdAttr.value)
    _attr.commitHmsAttr.setValue(commitHmsAttr.value)
    _attr.extensionAttr.setValue(extensionAttr.value)

    _attr
  }


}

class RsSqlTablesBean  extends GeneralBean with RsSqlTablesBeanTrait {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "RS_SQL_TABLES"

}