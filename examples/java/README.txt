README.txt (18-Feb-2012)

Examples Deployment Guide

The examples are:
	* Select_FlatResource
	* InsertUpdateDelete_FlatResource

-------------------------------------------------------------------------------
Configuration

First, follow the instructions for installing the SDK, particularly in setting up the sakila database. (See the restsql-sdk README or Deployment guide at http://restsql.org/doc/Deployment.html)

The example-restsql.properties file is loaded by the examples. The sqlresources dir will need to be changed if your sdk is not installed at /restsql/eclipse-workspace/restsql-sdk. (Note that the sql resources dir is an absolute directory). You will also likely need to change the database configuration in the properties file.

-------------------------------------------------------------------------------
Classpaths

The restsql jar must be in the classpath to compile. The restsql, log4j, commons-logging and database driver must be in the classpath to execute. 

-------------------------------------------------------------------------------
Example Compilation and Execution

To compile the classes:

$ cd WebContent/examples/java
$ javac -classpath ../../../../restsql/obj/lib/restsql-0.7.4.jar *.java

To run the Select_FlatResource class for mysql:

$ java -classpath ".;../../../../restsql/obj/lib/restsql-0.7.4.jar;../../../../restsql/lib/commons-logging-1.1.1.jar;../../../../restsql/lib/log4j-1.2.16.jar;../../../../restsql/lib/mysql-connector-java-5.1.14-bin.jar" Select_FlatResource