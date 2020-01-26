# Spark Cassandra to couchbase 

This Application help us migrate cassandra data to couchbase 

## Getting Started

Running the Job in Local

step 1) Clone repo 

    git clone https://github.com/shubhamdangare/casandra-to-coucbase-migration.git
    

    
step 2) Set Arguments in run.sh 

    1. Cassandra host
    2. Cassandra port
    3. Cassandra username
    4. Cassandra password
    5. Cassandra keyspace
    6. Cassandra table name 
    7. Couchbase host
    8. Couchbase port
    9. Couchbase username
    10.Couchbase password
    11.Couchbase bucket name
    
Example 

    ```
    --class com.knoldus.Migrator spark-template-migrater_2.11-0.1.jar localhost 9042 cassandra cassandra excelsior profile localhost 8091 Administrator password demo
    ```

step 3) cd to the cloned repo and run the script
    
        ./run.sh
