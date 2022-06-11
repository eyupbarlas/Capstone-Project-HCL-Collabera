# Capstone-Project-HCL-Collabera
Capstone Project for HCL / Collabera. 
> Project end date: 10.06.22  
> Project documentations: 11.06.22

## Architecture
![CapstoneProjectDiagram](https://user-images.githubusercontent.com/72407947/173202815-9b52736e-f68a-43ea-a1be-02fc86ef30df.png)


## About Project
  ***Work on progress***. This project is a web application contains a chatbot with login, registration and dashboard options. The user will register and login to the application. If the user's role is "ADMIN", user will have special access to the dashboard. After user logs in, user will be able to chat with chatbot. Chatbot has sample questions and answers ready-to-go in the MySQL database. All of the conversations will also be saved into MySQL database and if user has "ADMIN" role, user will have access to see the chat history with timestamps. 
  Project is built on 3 different microservices and an API Gateway. They are WebsiteService, APIService and EurekaServerService. They all deal with different requirements of the project and with this architecture, we avoid monolithic development.
  * Website Service will provide necessary routing between HTML pages and Spring Security login control and session mechanisms. The database entities, repositories and services are hold here.
  * API Service will provide(addition to same items in Website Service) API security configurations with JWT Tokens. 
  * Eureka Server Service(from Spring Cloud) holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.
  * API Gateway will provide us an effective way to route our APIs and help us with better monitoring, security and resiliency.

## Features
* User registration and ability to choose if user's role will be "USER" or "ADMIN". Different roles have different privileges.
* Spring Security and JWT Tokens for security purposes(APIs and sessions).
* Bootstrap 5 for better UI experience.
* Chatbot that provides answers for your questions.
* For "ADMIN", ability to see chat history and registered users.

## How To Use
### Required Modules & Programs
* Java 17+
* Spring Boot Web Framework
* MySQL 
* Postman(for API testing purposes)
* Bootstrap 5
* JavaScript AJAX(JQuery)

### Building the Project
* First step is the setup of Java to your machine. [Useful link from Oracle](https://www.java.com/en/download/help/download_options.html "Install Java").
* As for database, this project contains MySQL. In order to make the correct setup, we need to head to [MySQL website](https://dev.mysql.com/downloads/installer/ "mysql") and find the correct package to download. After setup, we need the [create our database](https://www.inmotionhosting.com/support/server/databases/create-a-mysql-database/ "database create").
* To build up the Spring Boot application, we need to head to [Spring Initalizr](https://start.spring.io/ "start spring"). We can select optimal versions of Java and Spring. Also we will select the project dependencies here.
* Lastly, to complete the preparation stage we need to fill our `application.properties` file. Copying the file in this project will be sufficent but database username and password must be filled by the project user. 
<br>

> **Personal Information**
> 
>> Eyüp Barlas  eyupbarlas2134@gmail.com
>> 
>> For more projects from Eyüp Barlas, [click here](https://github.com/eyupbarlas "eyups repos").
