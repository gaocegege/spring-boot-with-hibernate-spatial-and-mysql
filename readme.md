# Spring boot with hibernate spatial and mysql

Mysql 5.7.x supports spatial index in innodb engine, this is a demo.

## Requirements

1. Mysql 5.7.x
2. Maven and Java8

## How to use

First, you need to run the dbCreate.sql in `/db/dbCreate.sql` to create the table.

Then, you need to change the db connection configuration in `/src/main/resources/application.properties`.

run the command `mvn install`, you will see the result of the tests.