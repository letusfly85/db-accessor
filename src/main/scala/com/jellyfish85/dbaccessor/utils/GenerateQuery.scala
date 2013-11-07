package com.jellyfish85.dbaccessor.utils

import java.io.{InputStreamReader, BufferedReader, InputStream}

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

       val reader: BufferedReader =
         new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))

       val buf: StringBuffer = new StringBuffer()
       var switch: Boolean = true
       var content: String = ""
       while (switch) {
         content = reader.readLine()
         if (content.eq(null)) {
           switch = false

         } else {
           buf.append(content)
           buf.append("\n")
         }
       }

       query = buf.toString()
       query
     }
  }
}