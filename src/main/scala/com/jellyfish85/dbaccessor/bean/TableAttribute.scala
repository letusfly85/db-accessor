package com.jellyfish85.dbaccessor.bean

class TableAttribute {

  def logicalTableName:  String = _
  def physicalTableName: String = _

  def logicalColumnName:  String = _
  def physicalColumnName: String = _

  def dataBaseColumnType: String = _
  def javaFieldType:      String = _

  def isPk:     Boolean = _
  def nullAble: Boolean = _

}
