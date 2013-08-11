package com.jellyfish85.dbaccessor.dao

import com.jellyfish85.dbaccessor.utils.GenerateQuery

import java.sql.Connection

abstract class GeneralDao[A] extends GenerateQuery {

  def find(conn: Connection,   bean: A): List[A]

  def insert(conn: Connection, bean: A): Int

  def update(conn: Connection, bean: A): Int

  def delete(conn: Connection, bean: A): Int

  def merge(conn: Connection,  bean: A): Int

}