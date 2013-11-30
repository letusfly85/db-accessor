package com.jellyfish85.dbaccessor.dao.query.generate.tool

import org.specs2.mutable.Specification

import java.math.BigDecimal
import java.sql.SQLException

import com.jellyfish85.dbaccessor.manager.DatabaseManager
import com.jellyfish85.dbaccessor.bean.src.mainte.tool.KrObjectDependenciesBean

/**
 * == KrObjectDependenciesDaoTest ==
 *
 *
 * @author wada shunsuke
 * @since  2013/11/30
 * @todo
 *
 */
class KrObjectDependenciesDaoTest extends Specification {

  val db  = new DatabaseManager
  val dao = new KrObjectDependenciesDao

  "return true" should {
    assert(1 == 1)
  }

}
