package com.jellyfish85.dbaccessor

import com.jellyfish85.dbaccessor.utils.GenerateQuery

object Main {

  def main(args :Array[String]) {

    val generator: GenerateQuery = new GenerateQuery()
    println(generator.generateSimpleQuery("/query/erd/mainte/tool/SELECT_MS_TABLES.sql"))

  }

}
