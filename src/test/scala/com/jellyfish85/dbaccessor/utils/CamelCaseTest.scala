package com.jellyfish85.dbaccessor.utils

import org.specs2.mutable.Specification

/**
 * == CamelCaseTest ==
 *
 */
class CamelCaseTest extends Specification {

  val cc = new CamelCase {}

  "return true" should {
    cc.upperCamelCase("T_KK_KOKYK_KHN") must equalTo("TKkKokykKhn")
    cc.lowerCamelCase("T_KK_KOKYK_KHN") must equalTo("tKkKokykKhn")
  }
}
