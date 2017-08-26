I have use the following technologies for which I have attached the screenshot of all the artifacts(AuspostTestResults.docx) that was required.

a) Spring Boot
b) Java 1.8
c) Postman for sending request in GET and POST-- Restful services.
d) Maven for automated building the project.
e) Apacahe Derby Database: The capability provided by Spring Boot which automatically uses the Database. Other DB (MYSQL,Oracle etc) can be connected with the configuration in Application.properties (src/main/resources)

I have created project with name as "ausPostAssignment"
This project is for creating Restul Webservices which does the following:
		- Has Four Services in a List<> format 
			AddAddress
			getAllAddress
			getAddressBySuburb 
			getAddressByPostcode in .
		- Implemented secure Login feature for adding address as provided by Spring boot in AusPostSecurity. 
		- AusPostSecurity java is used for maintaing the username and password (ADMIN access) for adding address for the urls deployed on server.
		- Database connectivity is done by JPA capability provided by Spring boot as it is included in dependency of pom.xml (apache derby and JPA)


Process for Build Creation and other details:
1) Import the project as maven.
2) Execute the maven project as maven install.
3) This will create deployable war file which can be deployed to any application server.
		
Final WAR will be created at /ausPostAssignment/target/ausPostAssignment-1.0.0-SNAPSHOT.war which is ready to be deployed on any app server.
