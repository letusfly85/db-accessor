package com.jellyfish85.dbaccessor

import com.jellyfish85.dbaccessor.utils.GenerateQuery
import scaffold.generator.ORMapperGenerator

object Main extends GenerateQuery {

  def main(args :Array[String]) {

    val generator: ORMapperGenerator = new ORMapperGenerator
    generator.generateByVelocity("aaa")
  }
}
