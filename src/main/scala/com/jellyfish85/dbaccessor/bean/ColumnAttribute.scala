package com.jellyfish85.dbaccessor.bean

class ColumnAttribute[A] {

  var logicalColumnName:  String = _
  var physicalColumnName: String = _

  var dataBaseColumnType: String = _
  var javaFieldType:      String = _

  var value: A = _

  var isPk:     Boolean = _
  var nullAble: Boolean = _

  var isUpdateKey: Boolean = _
  var isTargetKey: Boolean = _

  def setValue(_value: A) {
    this.value = _value
  }

}
