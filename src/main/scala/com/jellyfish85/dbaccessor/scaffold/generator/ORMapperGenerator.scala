package com.jellyfish85.dbaccessor.scaffold.generator

import java.io._
import com.jellyfish85.dbaccessor.utils.CamelCase
import org.fusesource.scalate.{TemplateException, TemplateEngine}
import com.jellyfish85.dbaccessor.scaffold.dao.AllTabColumnsDao
import com.jellyfish85.dbaccessor.scaffold.bean.AllTabColumnsBean
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import org.apache.commons.io.FileUtils
import org.fusesource.scalate.support.ScalaCompiler

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
  val queryDir:  File = new File("output/scaffold/query")


  val db : DatabaseManager  = new DatabaseManager
  val dao: AllTabColumnsDao = new AllTabColumnsDao

  val beanName = (tableName: String) => upperCamelCase(tableName) + "Bean.scala"
  val daoName  = (tableName: String) => upperCamelCase(tableName) + "Dao.scala"

  val selectQuery = (tableName: String) => "SELLECT_" + tableName + ".sql"
  val deleteQuery = (tableName: String) => "DELETE_" + tableName + ".sql"
  val insertQuery = (tableName: String) => "INSERT_" + tableName + ".sql"
  val updateQuery = (tableName: String) => "UPDATE_" + tableName + ".sql"
  val mergeQuery  = (tableName: String) => "MERGE_"  + tableName + ".sql"

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

    if (!queryDir.exists()) {
      FileUtils.forceMkdir(queryDir)
    }
  }


  def generate(tableName: String) {
    initialize

    db.connect

    val bean: AllTabColumnsBean = new AllTabColumnsBean
    bean.ownerAttr.value     = db.user
    bean.tableNameAttr.value = tableName

    val list: List[AllTabColumnsBean] = dao.find(db.conn, bean)
    println(list.size)
    if (list.isEmpty) {
      println()

      return
    }

    val engine: TemplateEngine = new TemplateEngine()
    try {
      engine.workingDirectory = new File("tmp")

      val bindings = Map(
        "list" -> list
      )

      // bean, daoの生成
      val bean = engine.layout("/template/scaffold/scala/bean.ssp", bindings)
      val dao  = engine.layout("/template/scaffold/scala/dao.ssp",  bindings)

      val beanFile = new File(beanDir.getPath, beanName(tableName))
      var pw: PrintWriter = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(beanFile),"UTF-8")))
      pw.write(bean)
      pw.close()

      val daoFile = new File(daoDir.getPath, daoName(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(daoFile),"UTF-8")))
      pw.write(dao)
      pw.close()

      //TODO sqlの生成

    } catch {
      case e: TemplateException =>
        e.printStackTrace()

      case e: IOException =>
        e.printStackTrace()

    } finally {
      //TODO 必要か確認
      engine.compiler.asInstanceOf[ScalaCompiler].compiler.askShutdown()

    }
  }

}
