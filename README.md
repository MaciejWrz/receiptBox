# Receipt Box

## Purpose
Small application that allows performing basic CRUD operations on receipts.
Allows to store scanned receipts and keep shopping history.

This is only backend side. All operations are done with REST API.

## Development
### Prerequisites
 * Java 17
 * Docker and docker compose

Before starting application database needs to be started as well. To do this go to the application directory and type in terminal: </br>
`sudo docker compose up -d`

### Swagger
Api documentation can be found under: </br>
http://localhost:8080/swagger-ui/index.html

### Actuator
By default, only basic endpoints are enabled. To enable other endpoints proper configuration needs to be added in application.properties file. </br>
E.g. to enable all endpoints add `management.endpoints.web.exposure.include=*`

## TODO
There is still much to do:
* Adding Spring Security
* Tests both unit and integration
* Other...

