# Taxi service
###Main idea
This project represents a taxi service with functionality based on the MySQL. 
For this purpose client - server architecture was used. 
The service is available for authenticated drivers. 
Authentication is performed in web filters.

###Driver capabilities:
* registration (adding drivers), logging in and out;
* looking through lists of manufacturers, cars, drivers;
* adding manufacturers, cars, drivers, adding drivers to cars;
* deleting manufacturers, cars, drivers.

###Technologies Used
- Java 11
- Javax Servlet API 4.0.1
- JSTL 1.2
- JSP
- Apache Tomcat
- MySQL Connector Java 8.0.22
- Logging (Log4j)

###To run the project, you need to do these steps:
* clone the project and open it in an IDE;
* configure Tomcat (deployment: war_exploded, context address: "/");
* copy the script from init_db.sql to the MySQL Workbench;
* insert your properties in the ConnectionUtil class.