package com.jellyfish85.dbaccessor.bean.erd.release.controller

import com.jellyfish85.dbaccessor.bean.{ColumnAttribute, GeneralBean}
import java.math.BigDecimal

class TpTicketNumbers4releaseBean extends GeneralBean {

  val logicalTableName:  String =  ""
  val physicalTableName: String =  "TP_TICKET_NUMBERS4RELEASE"

  var releaseIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var trkmIdAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()
  var ticketNumberAttr:	ColumnAttribute[BigDecimal] = new ColumnAttribute()

}