REM User postgres must have superuser role
REM Using psql, execute 'alter user postgres with superuser'

SET user=postgres

psql --username=%user% < ../common/create-sakila-db.sql
psql --username=%user% sakila < sakila-schema.sql
psql --username=%user% sakila < sakila-schema-ext.sql
psql --username=%user% sakila < sakila-data.sql