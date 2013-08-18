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
      if (System.getProperty("app.env.name") == "development") {
        property.load(getClass().getResourceAsStream("/properties/dev.properties"))

      } else {
        property.load(getClass().getResourceAsStream("/properties/app.properties"))
      }

      val jdbcURL: String = property.getProperty("URL")
      val user:    String = property.getProperty("USER")
      val pass:    String = property.getProperty("PASS")

      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
      conn = DriverManager.getConnection(jdbcURL,user,pass)
      conn.setAutoCommit(false)

    } catch  {
      case e:Exception =>
        e.printStackTrace()
    }
  }

  def jRollback {
    if (!conn.isClosed) conn.rollback()
  }

  def jClose {
    if (!conn.isClosed) conn.close()
  }

  def jCommit {
    if (!conn.isClosed) conn.commit()
  }

}
