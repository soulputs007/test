package com.knoldus

case class CassandraConfig(
                            host: String,
                            port: String,
                            username: String,
                            password: String,
                            keyspace: String,
                            table :String
                          )

case class CouchbaseConfig(
                            host: String,
                            port: String,
                            username: String,
                            password: String,
                            bucket: String
                            )
