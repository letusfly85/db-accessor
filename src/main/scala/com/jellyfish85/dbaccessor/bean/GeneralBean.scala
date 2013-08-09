package com.jellyfish85.dbaccessor.bean

trait GeneralBean extends ColumnAttribute {

  val logicalTableName:  String
  val physicalTableName: String

}
