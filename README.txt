README.txt (14-Jul-2011)

restSQL SDK Deployment Guide

Project website is at http://restsql.org. Distributions at http://restsql.org/dist. Source code hosted at http://github.com/restsql.

-------------------------------------------------------------------------------
Structure and Distributions

restSQL source code is contained in three eclipse projects:
    1. restsql                      (service and core framework)
    2. restsql-sdk                  (documentation, HTTP API explorer, javadoc, examples)
    3. restsql-test                 (test framework, test cases)

restSQL binary distributions contain three libraries:
    1. restsql-{version}.jar        (core framework only)
    2. restsql-{version}.war        (service and core framework, 3rd party dependencies)
    3. restsql-sdk-{version}.war    {sdk)

restSQL source distributions consist of one jar:
    1. restsql-{version}-src.jar    (service and core framework)
    

-------------------------------------------------------------------------------
Installing restSQL SDK

Requirements: JEE Container, JAR tool, MySQL or PostgreSQL, Web Browser

Install restsql WAR mode (see restSQL README.txt) with one variation: the restsql.properties must be changed to reference the sdk's SQL Resources definition directory. Below is an example:

    # sqlresources.dir=/absolute/path
    sqlresources.dir=/opt/tomcat/webapps/restsql-sdk/sqlresources

Deploy: Extract restsql-sdk-{version}.war to your container's webapps directory, e.g. /opt/tomcat/webapps/restsql-sdk. Restart the container or use your preferred deloyment method.

    The SDK war contents are:
        restsql-sdk/
            api-explorer/
            database/
            defaults/
            doc/
            examples/
            javadoc/
            META-INF/
            sqlresources/
            wadl/
            WEB-INF/
    
    Note that the restsql-sdk war contains only static web content. 

Database: The HTTP API Explorer requires access to an extended sakila database (http://dev.mysql.com/doc/sakila/en/sakila.html). It is extended for the restsql-sdk with new tables and data. Bash and Windows batch scripts are provided to create the base and extended database for MySQL and for PostgreSQL. The bash script is restsql-sdk/database/<database>/create-sakila.sh and the Windows batch script is restsql-sdk/database/<database>/create-sakila.bat, where database is either mysql or postgresql. You will need to change the user and password variables in the beginning of the script to an account that has database and table creation privileges.

Troubleshooting: The HTTP API Explorer requires access to a restsql service instance. If you have not deployed restsql to the same host/port as the SDK and to the location /restsql, then you will need to make one small tweak. Change two Javascript variables in restsql-sdk/api-explorer/index.html. Here is an example:

    var restsqlHost = "http://somehost:8080";
    var restsqlBaseUri = "/restsql-0.6";


-------------------------------------------------------------------------------
License

restSQL is licensed under the standard MIT license. Refer to the LICENSE.txt and CONTRIBUTORS.txt in the distribution.