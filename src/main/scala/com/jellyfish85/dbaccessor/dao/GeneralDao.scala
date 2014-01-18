package com.jellyfish85.dbaccessor.dao

import com.jellyfish85.dbaccessor.utils.{JavaConverter, GenerateQuery, DBAttributeTrait}

import java.sql.Connection

abstract class GeneralDao[A] extends GenerateQuery with JavaConverter[A] with DBAttributeTrait {

  def find(conn: Connection,   bean: A): List[A]

  def insert(conn: Connection, list: List[A]): Int

  def update(conn: Connection, list: List[A]): Int

  def delete(conn: Connection, bean: A): Int

  def merge(conn: Connection,  bean: A): Int

}