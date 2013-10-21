package com.jellyfish85.dbaccessor.scaffold.generator

import java.io._
import com.jellyfish85.dbaccessor.utils.{TypeMapper, CamelCase}
import org.fusesource.scalate.{TemplateException, TemplateEngine}
import com.jellyfish85.dbaccessor.manager.DatabaseManager
import org.apache.commons.io.FileUtils
import org.fusesource.scalate.support.ScalaCompiler
import com.jellyfish85.dbaccessor.dao.scaffold.AllTabColumnsDao
import com.jellyfish85.dbaccessor.bean.scaffold.AllTabColumnsBean

/**
 * == ORMapper Generator ==
 *
 * it generates bean, dao, queries from meta info of RDBMS table.
 *
 */
class ORMapperGenerator extends CamelCase {

  val outputDir: File = new File("output")
  val beanDir:   File = new File("output/scaffold/bean")
  val daoDir:    File = new File("output/scaffold/dao")
  val queryDir:  File = new File("output/scaffold/query")

  val db : DatabaseManager  = new DatabaseManager
  val dao: AllTabColumnsDao = new AllTabColumnsDao

  val beanName      = (tableName: String) => upperCamelCase(tableName) + "Bean"
  val beanFileName  = (tableName: String) => beanName(tableName)  + ".scala"

  val daoName       = (tableName: String) => upperCamelCase(tableName) + "Dao"
  val daoFileName   = (tableName: String) => daoName(tableName)   + ".scala"

  val selectQuery = (tableName: String) => "SELECT_" + tableName + ".sql"
  val deleteQuery = (tableName: String) => "DELETE_" + tableName + ".sql"
  val insertQuery = (tableName: String) => "INSERT_" + tableName + ".sql"
  val updateQuery = (tableName: String) => "UPDATE_" + tableName + ".sql"
  val mergeQuery  = (tableName: String) => "MERGE_"  + tableName + ".sql"

  /**
   * == initialize ==
   *
   * if there is not output directory, make it.
   *
   * and if there are subdirectories below it,
   * delete them and remake after then.
   *
   */
  def initialize {
    if (!outputDir.exists()) {
      FileUtils.forceMkdir(outputDir)
    }

    if (beanDir.exists())  FileUtils.deleteDirectory(beanDir)
    FileUtils.forceMkdir(beanDir)

    if (daoDir.exists())   FileUtils.deleteDirectory(daoDir)
    FileUtils.forceMkdir(daoDir)

    if (queryDir.exists()) FileUtils.deleteDirectory(queryDir)
    FileUtils.forceMkdir(queryDir)
  }


  /**
   * == generate ==
   *
   * generate bean, dao and queries
   *
   * @param tableName oracle table name
   */
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

    val tm: TypeMapper = new TypeMapper {}
    val cc: CamelCase  = new CamelCase  {}
    val engine: TemplateEngine = new TemplateEngine()
    try {
      engine.workingDirectory = new File("tmp")

      val bindings = Map(
        "tableName"   -> tableName,
        "list"        -> list,
        "beanName"    -> beanName(tableName),
        "daoName"     -> daoName(tableName),
        "cc"          -> cc,
        "tm"          -> tm,
        "selectQuery" -> selectQuery(tableName),
        "deleteQuery" -> deleteQuery(tableName),
        "insertQuery" -> insertQuery(tableName),
        "updateQuery" -> updateQuery(tableName),
        "mergeQuery"  -> mergeQuery(tableName)
      )

      // generate bean and dao
      val bean = engine.layout("/template/scaffold/scala/bean.ssp", bindings)
      val dao  = engine.layout("/template/scaffold/scala/dao.ssp",  bindings)

      val beanFile = new File(beanDir.getPath, beanFileName(tableName))
      var pw: PrintWriter = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(beanFile),"UTF-8")))
      pw.write(bean)
      pw.close()

      val daoFile = new File(daoDir.getPath, daoFileName(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(daoFile),"UTF-8")))
      pw.write(dao)
      pw.close()

      //generate queries
      val selectStr = engine.layout("/template/scaffold/sql/select.ssp", bindings)
      val updateStr = engine.layout("/template/scaffold/sql/update.ssp", bindings)
      val mergeStr  = engine.layout("/template/scaffold/sql/merge.ssp",  bindings)
      val insertStr = engine.layout("/template/scaffold/sql/insert.ssp", bindings)
      val deleteStr = engine.layout("/template/scaffold/sql/delete.ssp",  bindings)

      val selectFile = new File(queryDir.getPath, selectQuery(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(selectFile),"UTF-8")))
      pw.write(selectStr)
      pw.close()

      val updateFile = new File(queryDir.getPath, updateQuery(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(updateFile),"UTF-8")))
      pw.write(updateStr)
      pw.close()

      val mergeFile  = new File(queryDir.getPath, mergeQuery(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(mergeFile),"UTF-8")))
      pw.write(mergeStr)
      pw.close()

      val insertFile = new File(queryDir.getPath, insertQuery(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(insertFile),"UTF-8")))
      pw.write(insertStr)
      pw.close()

      val deleteFile = new File(queryDir.getPath, deleteQuery(tableName))
      pw = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(deleteFile),"UTF-8")))
      pw.write(deleteStr)
      pw.close()

    } catch {
      case e: TemplateException =>
        e.printStackTrace()

      case e: IOException =>
        e.printStackTrace()

    } finally {
      //TODO need to confirm if it's necessary or not.
      engine.compiler.asInstanceOf[ScalaCompiler].compiler.askShutdown()

    }
  }

}
