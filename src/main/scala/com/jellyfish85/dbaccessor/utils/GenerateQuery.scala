package com.jellyfish85.dbaccessor.utils

import java.io.{InputStreamReader, BufferedReader, InputStream}
import scala.collection.JavaConversions._

trait GenerateQuery {

  /**
   * parameter called from PreparedStatement
   */
  var query: String = _

  /**
   * == generateSimpleQuery ==
   *
   * generate simple query by reading from a SQL file
   *
   * @param path the path from the project resources folder
   * @return query
   */
  def generateSimpleQuery(path: String): String = {
     try {
       val inputStream: InputStream = getClass().getResourceAsStream(path)
       val br: BufferedReader =
         new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))

       Stream.continually(br.readLine()).takeWhile(_ != null).foreach {str: String =>
         query += str
       }
       query
     }
  }

  /**
   * == generateSQLIncludesList ==
   *
   * @param path
   * @param map
   * @return
   */
  def generateSQLIncludesList(path: String, map: Map[String, List[String]]): String = {

    var reg = "xxxxx".r
    var lines:  String = ""
    var _lines: String = ""
    query = ""
    val inputStream: InputStream = getClass().getResourceAsStream(path)

    val reader: BufferedReader =
      new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))

    val buf: StringBuffer = new StringBuffer()
    var switch: Boolean = true
    while (switch) {
      lines = reader.readLine()
      _lines = ""
      if (lines.eq(null)) {
        switch = false

      } else {

        for ((key, value) <- map) {
          reg = key.r
          if (reg.findAllIn(lines).length > 0) {

            value.foreach {entry: String =>
              _lines += "?,"
            }
            _lines += ")"
            _lines = _lines.replace("?,)", "?")
            lines = lines.replaceAll(key, _lines)
          }
        }

        buf.append(lines)
        buf.append("\n")
      }
    }

    query += buf.toString
    query
  }

  def generateSQLIncludesList(path: String, map: java.util.Map[String, java.util.ArrayList[String]]): String = {
    var _map: Map[String, List[String]] = Map()
    map.foreach{ case(key, value) =>
      _map = Map(key -> value.toList )
    }

    return generateSQLIncludesList(path, _map)
  }
}