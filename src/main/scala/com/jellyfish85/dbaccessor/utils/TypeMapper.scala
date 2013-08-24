package com.jellyfish85.dbaccessor.utils

trait TypeMapper {

  def convertOracleType2Java(columnType: String): String = {
    columnType match {
      case "CHAR" =>
        //"java.lang.String"
        "String"

      case "VARCHAR2" =>
        //"java.lang.String"
        "String"

      case "LONGVARCHAR" =>
        //"java.lang.String"
        "String"

      case "ROWID" =>
        //"java.lang.String"
        "String"

      case "NUMBER" =>
        //"java.math.BigDecimal"
        "BigDecimal"

      case "DATE" =>
        "java.util.Date"

      case "LONGRAW" =>
        "byte[]"

      case "RAW" =>
        "byte[]"

      case "BLOB" =>
        "byte[]"

      case "CLOB" =>
        "byte[]"

      case "BIT" =>
        "Boolean"

      case "INT"=>
        "Int"

      case "MN" =>
        //"java.math.BigDecimal"
        "BigDecimal"

      case "TIMESTAMP" =>
        "java.sql.Timestamp"

      case "TIMESTAMP(6)" =>
        "java.sql.Timestamp"

      case _ =>
        throw new IllegalArgumentException("["+ columnType +"]はJavaのFieldに変換できない不正なDBMS属性です。")
    }
  }
}