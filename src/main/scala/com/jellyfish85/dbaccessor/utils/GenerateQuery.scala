package com.jellyfish85.dbaccessor.utils

import java.io.{InputStreamReader, BufferedReader, InputStream}

object GenerateQuery {
  var query: String = _

  /**
   * in句などの中身のないqueryを生成する
   *
   * @param path sqlのresourcesフォルダからのファイルパス
   * @return query
   */
  def generateSimpleQuery(path: String): String = {

     try {
       val inputStream: InputStream = getClass().getResourceAsStream("/" + path)

       val reader: BufferedReader =
         new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))

       var content: String = ""
       while ((content = reader.readLine()) != null) {
         buf.append(contents)
         buf.append("\n")
       }

       query = buf.toString()
       query
     }
  }
}
