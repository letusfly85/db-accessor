package com.jellyfish85.dbaccessor.scaffold.generator

import java.io.File
import com.jellyfish85.dbaccessor.utils.CamelCase
import org.fusesource.scalate.{TemplateException, TemplateEngine}
import com.jellyfish85.dbaccessor.scaffold.dao.AllTabColumnsDao
import com.jellyfish85.dbaccessor.scaffold.bean.AllTabColumnsBean
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import org.apache.commons.io.FileUtils

/**
 * == ORMapper Generator ==
 *
 * テーブルのメタ情報をもとにbeanとdaoを自動生成する
 *
 */
class ORMapperGenerator extends CamelCase {

  val outputDir: File = new File("output")
  val beanDir:   File = new File("output/scaffold/bean")
  val daoDir:    File = new File("output/scaffold/dao")


  val db : DatabaseManager  = new DatabaseManager
  val dao: AllTabColumnsDao = new AllTabColumnsDao

  val beanName = (tableName: String) => upperCamelCase(tableName) + "Bean.scala"
  val daoName  = (tableName: String) => upperCamelCase(tableName) + "Dao.scala"

  def initialize {
    if (!outputDir.exists()) {
      FileUtils.forceMkdir(outputDir)
    }

    if (!beanDir.exists()) {
      FileUtils.forceMkdir(beanDir)
    }

    if (!daoDir.exists()) {
      FileUtils.forceMkdir(daoDir)
    }
  }


  def generate(tableName: String) {
    initialize

    db.connect

    val bean: AllTabColumnsBean = new AllTabColumnsBean
    bean.ownerAttr.value     = db.user
    bean.tableNameAttr.value = tableName

    val list: List[AllTabColumnsBean] = dao.find(db.conn, bean)

    val engine: TemplateEngine = new TemplateEngine()
    try {
      engine.workingDirectory = new File("tmp")

      val bindings = Map(
        "list" -> list
      )

      val bean = engine.layout("/template/scaffold/bean.ssp", bindings)
      val dao  = engine.layout("/template/scaffold/dao.ssp",  bindings)

    } catch {
      case e: TemplateException =>
        e.printStackTrace()
    }
  }

}
