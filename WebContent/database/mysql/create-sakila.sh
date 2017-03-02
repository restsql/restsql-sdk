#!/bin/bash

user=root
password=root

mysql -u $user --password=$password < sakila-schema.sql
mysql -u $user --password=$password < sakila-schema-ext.sql
mysql -u $user --password=$password < sakila-data.sql
mysql -u $user --password=$password < sakila-data-ext.sql