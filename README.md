# restexample
An example rest api project. 

### Backend Technologies
* Java
* Spring
* Mysql

### Frontend Technologies
* Angular2
* Typescript
* PrimeNG


# How to install

## What you will need
* mysql server
* nginx
* java
* gradle
* npm

  

## Start mysql
* install mysql server
* start mysql server 
* create a db 
  * url = jdbc:mysql://localhost:3306/rest
  * username = root
  * password = root

## Configure proxy settings
* start nginx with [nginx.conf](./nginx.conf)  file

## Start backend  
* cd backend
* gradle build
* java -jar build/libs/rest-api-0.0.1-SNAPSHOT.jar

At this point, be sure http://localhost:9090/api/task is up.

## Start frontend
* cd frontend
* npm install
* npm start

At this point, be sure http://localhost:8080 is up.

