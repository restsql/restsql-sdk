#!/bin/bash

user=postgres

psql --username=$user < ../common/create-sakila-db.sql
psql --username=$user sakila < sakila-schema.sql
psql --username=$user sakila < sakila-schema-ext.sql
psql --username=$user sakila < sakila-data.sql