# SpringHotel
CRUD - spring - hotel

This is a basic Spring MVC Hibernate MySQL Integration CRUD  application. We have Controller layer- service layer- data layer - model layer

Spring 4.1.5.RELEASE
Hibernate 4.3.8.Final
mysql 5.1.45

We are using  hibernate and spring MVC framework for integration.

configure the database in application.properties file with mysql

#Database related properties
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/dbname
database.user=username
database.password=pwd

#Hibernate related properties
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.show_sql=true
hibernate.format_sql=true
hibernate.hbm2ddl.auto=update

Create table in mysql database

To create a dynamic project in maven navigate to the folder where you want to create the project(PROJECTNAME) and execute following command in Command
Prompt.

mvn archetype:generate -DgroupId=com.jwt.spring -DartifactId=PROJECTNAME -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

then Convert Maven Project to support Eclipse

mvn eclipse:eclipse -Dwtpversion=2.0

import the project to eclipse

declare the hibernate and database properties

Creating Deployment Descriptor (web.xml) & Spring Configuration File (spring-servlet.xml)

create the java directory with persistance layer/DAO layer /service layer/ controller layer

Create jsp file named inside "src\main\webapp\WEB-INF\pages" directory of the project
