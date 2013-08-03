package com.jellyfish85.dbaccessor.manager

import java.sql.{DriverManager, Connection}
import java.util.Properties

class DatabaseManager {

  var conn: Connection = _

  /**
   * Database接続を行う
   *
   */
  def connect {

    val property: Properties = new Properties()

    try {
      property.load(getClass().getResourceAsStream("/.properties"))

      val jdbcURL: String = property.getProperty("URL")
      val user:    String = property.getProperty("USER")
      val pass:    String = property.getProperty("PASS")

      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
      conn = DriverManager.getConnection(jdbcURL,user,pass)

    } catch  {
      case e:Exception =>
        e.printStackTrace()
    }
  }

  def jClose {
    if (!conn.isClosed) conn.close()
  }

}
