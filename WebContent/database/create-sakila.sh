#!/bin/bash

user=root
password=root

mysql -u $user --password=$password < create-sakila.sql
mysql -u $user --password=$password sakila < sakila-schema.sql
mysql -u $user --password=$password sakila < sakila-schema-ext.sql
mysql -u $user --password=$password sakila < sakila-data.sql