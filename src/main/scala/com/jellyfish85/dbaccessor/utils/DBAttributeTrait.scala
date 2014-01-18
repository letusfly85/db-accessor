package com.jellyfish85.dbaccessor.utils

import java.sql.{DatabaseMetaData, Connection}

trait DBAttributeTrait {

  /**
   *
   *
   * @param conn
   * @return
   */
  def getSchemaName(conn: Connection): String = {
    val metaData: DatabaseMetaData = conn.getMetaData

    return metaData.getUserName
  }

}
