package com.knoldus

import com.couchbase.spark._
import com.couchbase.spark.sql._
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions._

object Migrator {

  def main(args: Array[String]): Unit = {

    val (cassandraConfig, couchbaseConfig) = Initializer.initialize(args)

    val spark = SparkSession.builder()
      .appName("cassandra-couchbase-migrator")
      .config("spark.couchbase.nodes", couchbaseConfig.host)
      .config("spark.couchbase.port", couchbaseConfig.port)
      .config("spark.couchbase.username", couchbaseConfig.username)
      .config("spark.couchbase.password", couchbaseConfig.password)
      .config(s"spark.couchbase.bucket.${couchbaseConfig.bucket}", "")
      .config("spark.cassandra.connection.host", cassandraConfig.host)
      .config("spark.cassandra.connection.port", cassandraConfig.port)
      .config("spark.cassandra.auth.username", cassandraConfig.username)
      .config("spark.cassandra.auth.password", cassandraConfig.password)
      .getOrCreate()

    val cassandraRDD = spark
      .read
      .format("org.apache.spark.sql.cassandra")
      .options(Map("table" -> cassandraConfig.table, "keyspace" -> cassandraConfig.keyspace))
      .load()

    val rddToBeWritten = cassandraRDD.withColumn("META_ID", monotonically_increasing_id)

    rddToBeWritten.toDF().write.mode(SaveMode.Overwrite).couchbase()
  }

}
