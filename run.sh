sbt package

/home/knoldus/Downloads/spark-2.3.3-bin-hadoop2.7/bin/spark-submit \
--master local \
--packages com.datastax.spark:spark-cassandra-connector_2.11:2.3.0,com.couchbase.client:spark-connector_2.11:2.3.0 \
--class com.knoldus.Migrator \
target/scala-2.11/spark-template-migrater_2.11-0.1.jar \
localhost \
9042 \
cassandra \
cassandra \
excelsior \
profile \
localhost \
8091 \
Administrator \
password    \
demo