package com.jellyfish85.dbaccessor.scaffold

import generator.ORMapperGenerator

/**
 * == GenerateDBAccessorSuite ==
 *
 * generate bean, dao and queries
 * All of inputs are meta info in Database.
 *
 * need an argument, table name.
 *
 */
object GenerateDBAccessorSuite {

  def main(args: Array[String]) {
    val tableName: String = args(0)

    val generator: ORMapperGenerator = new ORMapperGenerator
    generator.generate(tableName)
  }

}
