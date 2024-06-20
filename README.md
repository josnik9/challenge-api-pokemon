# api-pokemon

This project use spring-boot, this project is created for a technical challenge.

### Prerequisite

1) Java 17

### To run this application

You can run this application using:
```shell script
 ./mvnw spring-boot:run
```

###### Test Application:
You have to import WSLD schema at some software that use SOAP.
This is the URL schema: http://localhost:8080/ws/pokemon.wsdl

There are six methods: 

- getAbilities
- getBaseExperience
- getHeldItems
- getId 
- getLocationAreaEncounters
- getName

All methods receive a pokemon's name