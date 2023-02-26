# Springboot Custom Interceptor

<div align="center">
	<a target="_blank" href="https://github.com"><img alt="github" src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/></a>
	<a target="_blank" href="https://spring.io"><img alt="spring" src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/></a>
	<a target="_blank" href="https://maven.apache.org"><img alt="maven" src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/></a>
	<a target="_blank" href="https://junit.org/junit5"><img alt="junit" src="https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white"/></a>
	<a target="_blank" href="https://www.postgresql.org"><img alt="postgresql" src="https://img.shields.io/badge/PostgreSQL-6236FF?style=for-the-badge&logo=postgresql&logoColor=white"/></a>
</div>

## Description

API CRUD example using:
- DDD structure
- Custom exceptions
- Rest controller advice
- Api docs with swagger
- Custom interceptor to obtain a detailed log of the application's requests and responses. 
- Unit test (JUnit5 + Mockito)
- Sonarqube analysis
- Postman collection

## Requirements

- Java 11
- Maven 3.6.3
- Postgresql 13.2 (You can use another database, but you must change the dependencies in pom.xml)
- Postman (Optional)
- Sonarqube (Optional)
- Intellij Idea (Optional)
- Lombok (Recommended)

## Structure of project

```
.
├──  domain                 # Business layer
     ├──  dto               # DTO
     ├──  service           # Logic layer
          ├──  impl         # Implementation of service
├──  exception		    # Handle custom exception
     ├──  controller	    # Rest Controller Advice
     ├──  dto		    # Custom DTO
├──  interceptor            # Custom Interceptor
     ├── dto         	    # Logger DTO for custom interceptor
     ├── service            # Service to log trace for custom interceptor
├──  persistence            # Data access
     ├──  entity            # Entities used in app
     ├──  mapper            # Mapper entities to DTO
          ├──  impl         # Implementation of mappers
     ├──  repository        # Repositories (JPA, CrudRepository, etc)
├──  util                   # Constants, formatters, etc
├──  web                    # REST Controller
├── dto                     # DTO example (Request and Response)
├── interceptor             # Interceptor config
    ├── dto         	    # Logger DTO
    ├── service             # Service to log trace
├── web			    # Rest Controller
├── postman                 # Folder to save  collection post
```
## How to use

1. Clone repository.
2. Open folder.
3. In folder ```src/main/resources``` it's located SQL file for this app
4. Run:
	```
	mvn clean && mvn install
	```
5. Open in your favorite IDE (I use Intellij Idea).
6. Use postman to test (Collection included in ```postman``` folder).
7. The endpoint is (http://localhost:8010/api-crud/v1/)[http://localhost:8010/api-crud/v1/]
8. Documentation of API is in (http://localhost:8010/api-crud/v1/swagger-ui.html)[http://localhost:8010/api-crud/swagger-ui.html]

## Screenshots

### Swagger

![Swagger](https://raw.githubusercontent.com/jsalonl/api-crud-interceptor/main/screenshots/ss1.png)

![Swagger](https://raw.githubusercontent.com/jsalonl/api-crud-interceptor/main/screenshots/ss2.png)

### LOG with custom interceptor is enabled

![Log](https://raw.githubusercontent.com/jsalonl/api-crud-interceptor/main/screenshots/ss3.png)

### Sonarqube analysis

![Sonar](https://raw.githubusercontent.com/jsalonl/api-crud-interceptor/main/screenshots/ss4.png)

## TODO

- Make archetype in maven to facilitate implementation

## Do you want to support me?

<a href="https://www.buymeacoffee.com/JoanSalomon" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-red.png" alt="Buy Me A Coffee" style="height: 60px !important;width: 217px !important;" ></a>
