# SPRING TRANSACTION LAB

This project has some case studies on spring transactions.

- `SpringTransactionLabApplicationLoader` class implements `CommandLineRunner` class. 
This class has my scenario for tracking the Spring transaction management. 
You will see the usages of Transaction annotation's `propagation` and `rollbackFor` attributes.

## Requirements

- Java 17

## How to Run

- You can run the application with the maven spring-boot plugin:
```
mvn spring-boot:run
```
**_P.S._**: Configurations of the project are in **application.yml** file. You may want to change them.
If you want to change them, you can run the application with giving them to the command of maven spring-boot plugin dynamically.
See details of running an application with maven: https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#run
