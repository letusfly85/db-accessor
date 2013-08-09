package com.jellyfish85.dbaccessor.bean

class ColumnAttribute {

  var logicalColumnName:  String = _
  var physicalColumnName: String = _

  var dataBaseColumnType: String = _
  var javaFieldType:      String = _

  var value: Object = _

  var isPk:     Boolean = _
  var nullAble: Boolean = _

  var isUpdateKey: Boolean = _
  var isTargetKey: Boolean = _

}
