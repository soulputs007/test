package com.knoldus

object Initializer {

  def initialize(arguments: Array[String]): (CassandraConfig, CouchbaseConfig) = {
    (
      CassandraConfig(
        arguments(0),
        arguments(1),
        arguments(2),
        arguments(3),
        arguments(4),
        arguments(5)
      )
      ,
      CouchbaseConfig(arguments(6),
        arguments(7),
        arguments(8),
        arguments(9),
        arguments(10))
    )
  }
}
