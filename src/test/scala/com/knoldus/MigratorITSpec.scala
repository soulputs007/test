package com.knoldus

import com.couchbase.spark._
import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfter, FlatSpec}

class MigratorITSpec extends FlatSpec with BeforeAndAfter {
  var spark: SparkSession = _

  before {
    spark = SparkSession.builder()
      .master("local")
      .appName("cassandra-couchbase-migrator")
      .config("spark.couchbase.nodes","localhost" )
      .config("spark.couchbase.port", "8091")
      .config("spark.couchbase.username", "Administrator")
      .config("spark.couchbase.password", "password")
      .config(s"spark.couchbase.bucket.demo1", "")
      .config("spark.cassandra.connection.host","localhost" )
      .config("spark.cassandra.connection.port", "9042")
      .config("spark.cassandra.auth.username", "cassandra")
      .config("spark.cassandra.auth.password", "cassandra")
      .getOrCreate()
  }


  "Spark cassandra couchbase migration Integration Testing" should "load cassandra data" in {

    spark
      .read
      .format("org.apache.spark.sql.cassandra")
      .options(Map("table" -> "profile", "keyspace" -> "excelsior"))
      .load()
  }

  after {

    spark.stop()
  }


}
