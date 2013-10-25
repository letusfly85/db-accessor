package com.jellyfish85.dbaccessor.utils

import java.util

trait JavaConverter[A] {

  def convert(list: List[A]): util.ArrayList[A] = {

    val resultList: util.ArrayList[A] = new util.ArrayList[A]()
    list.foreach {entry: A => resultList.add(entry)}

    resultList
  }

}
