# Hello World

This is a test application to present minimal RESTful WS implementation using Spring Boot

## Configuration

Configuration properties are place in src/main/resources/application.properties file.
Full list of available properties can be found here:
http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

## Test

```
mvn test
```

## Run

```
mvn spring-boot:run
```

## Package

```
mvn package
```

It will produce JAR file in path 'target/helloworld-0.0.1-SNAPSHOT.jar' which can by executed by command:

```
java -jar target/helloworld-0.0.1-SNAPSHOT.jar
```
