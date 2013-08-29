package com.jellyfish85.dbaccessor.utils

/**
 *
 *
 *
 */
trait CamelCase {

  /**
   * == lowerCamelCase ==
   *
   * convert separated by underscore string to lower camel case.
   *
   * @param  str target
   * @return string
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
   * == upperCamelCase ==
   *
   * convert separated by underscore string to lower camel case.
   *
   * @param  str target
   * @return string
   *
   */
  def upperCamelCase(str: String): String = {
    lowerCamelCase(str).capitalize
  }

}
