#!/bin/bash

user=sakila
password=sakila

sqlplus $user/$password @sakila-schema.sql
sqlplus $user/$password @sakila-schema-ext.sql
sqlplus $user/$password @sakila-insert-data.sql
