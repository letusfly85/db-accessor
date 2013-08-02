package com.jellyfish85.dbaccessor.bean

class TableAttribute {

  var logicalTableName:  String = _
  var physicalTableName: String = _

  var logicalColumnName:  String = _
  var physicalColumnName: String = _

  var dataBaseColumnType: String = _
  var javaFieldType:      String = _

  var isPk:     Boolean = _
  var nullAble: Boolean = _

}
