# Capstone-Project-HCL-Collabera
Capstone Project for HCL / Collabera. 

## Architecture

## About Project & Features
  This project is a web application contains a chatbot with login, registration and dashboard options. The user will register and login to the application. If the user's role is "ADMIN", user will have special access to the dashboard. After user logs in, user will be able to chat with chatbot. Chatbot has sample questions and answers ready-to-go in the MySQL database. All of the conversations will also be saved into MySQL database and if user has "ADMIN" role, user will have access to see the chat history with timestamps.

## How To Use
### Required Modules
* Java 17+
* Spring Boot Web Framework
* MySQL 
* Postman(for API testing purposes)

### Building the Project
* First step is the setup of Java to your machine. [Useful link from Oracle](https://www.java.com/en/download/help/download_options.html "Install Java")
* As for database, this project contains MySQL. In order to make the correct setup, we need to head to [MySQL website](https://dev.mysql.com/downloads/installer/ "mysql") and find the correct package to download. After setup, we need the [create our database](https://www.inmotionhosting.com/support/server/databases/create-a-mysql-database/ "database create").
* To build up the Spring Boot application, we need to head to [Spring Initalizr](https://start.spring.io/ "start spring"). We can select optimal versions of Java and Spring. Also we will select the project dependencies here.
* Lastly, to complete the preparation stage we need to fill our `application.properties` file. 

