package com.jellyfish85.dbaccessor.utils

/**
 *
 *
 *
 */
trait CamelCase {

  /**
   * == CamelCase変換（先頭小文字） ==
   *
   * 先頭小文字始まりにしてCamelCase変換をした文字列を返却する
   *
   * @param  str 対象文字列
   * @return 置換後文字列
   */
  def lowerCamelCase(str: String): String = {
    val buf: StringBuffer = new StringBuffer()
    var pre: Char = '+'

    var idx: Int = 0
    str.foreach {c: Char =>
      if (pre == '_') {
        buf.append(c.toString.toUpperCase)
        idx += 1

      } else if (c == '_') {


      } else {
        buf.append(c.toString.toLowerCase)
      }

      pre = c
    }

    buf.toString
  }

  /**
   * == CamelCase変換（先頭小文字） ==
   *
   * 先頭大文字始まりにしてCamelCase変換をした文字列を返却する
   *
   * @param str
   * @return
   */
  def upperCamelCase(str: String): String = {
    lowerCamelCase(str).capitalize
  }

}
