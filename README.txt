README.txt (15-Mar-2017)

restSQL SDK Deployment Guide

Project website is at http://restsql.org. Distributions at http://restsql.org/dist. Release history at http://restsql.org/doc/ReleaseHistory.html. Source code hosted at http://github.com/restsql.

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

restSQL docker images:
	1. restsql/service - service and core framework
	2. restsql/service-sdk - service and core framework + sdk
	3. restsql/mysql-sakila - MySQL 7 + Sakila + restsql-test extensions

-------------------------------------------------------------------------------
Versions

The restsql and restsql-sdk versions are found in the jar and war's META-INF/MANIFEST.MF. It is also found in the the source tree in restsql/build.properties and restsql-sdk/build.properties in the property build.version. 


-------------------------------------------------------------------------------
Installing restSQL SDK

Requirements: JEE Container, JAR tool, MySQL or PostgreSQL, Web Browser

Enable directory listings in your app container's config. For example for Tomcat, edit $TOMCAT_HOME/conf/web.xml section for the DefaultServlet, setting the directory listing value to true:

    <servlet>
        <servlet-name>default</servlet-name>
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
        <init-param>
            <param-name>debug</param-name>
            <param-value>0</param-value>
        </init-param>
        <init-param>
            <param-name>listings</param-name>
            <param-value>true</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet> 

Install restsql WAR mode (see restSQL README.txt) with one variation: the restsql.properties must be changed to reference the sdk's SQL Resources definition directory. Below is an example:

    # sqlresources.dir=/absolute/path
    sqlresources.dir=/opt/tomcat/webapps/restsql-sdk/examples/sqlresources

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
            wadl/
            WEB-INF/
    
    Note that the restsql-sdk war contains only static web content. 

Database: The HTTP API Explorer requires access to an extended sakila database (http://dev.mysql.com/doc/sakila/en/sakila.html). It is extended for the restsql-sdk with new tables and data. Bash and Windows batch scripts are provided to create the base and extended database for MySQL and for PostgreSQL. The bash script is restsql-sdk/database/<database>/create-sakila.sh and the Windows batch script is restsql-sdk/database/<database>/create-sakila.bat, where database is either mysql or postgresql. You will need to change the user and password variables in the beginning of the script to an account that has database and table creation privileges.

Troubleshooting: The HTTP API Explorer requires access to a restsql service instance. If you have not deployed restsql to the same host/port as the SDK and to the location /restsql, then you will need to make one small tweak. Change two Javascript variables in restsql-sdk/api-explorer/index.html. Here is an example:

    var restsqlHost = "http://somehost:8080";
    var restsqlBaseUri = "/restsql-0.7";


-------------------------------------------------------------------------------
License

restSQL is licensed under the standard MIT license. Refer to the LICENSE.txt and CONTRIBUTORS.txt in the distribution.