
## **Pokédex**

This is a training project developed using Spring Boot, MySql, JPA, Typescript and Angular 11.
_____________________________
### **Objective**
User will be able to:
 - Register new Pokémon;
 - Retrieve the list of registered pokémons;
 - Edit an previous Pokémon;
 - Delete an existing Pokémon;
 - Search the species and skills for that Pokemon;
 - Provide a city name and receive a list of pokemons that will be probably appearing in there based on the current weather and pokémon type.

### Rules for retrieving the pokémons weather based

- cities where the temperature is:
    - Less then **(<) 5ºC**, will retrieve **ice** pokémons;
    - Between **(>=) 5ºC and (<) 10ºC** will retrieve **water** pokémons;
    - Between **(>=) 12ºC and (<) 15ºC** will retrieve **grass** pokémons;
    - Between **(>=) 15ºC and (<) 21ºC** will retrieve **ground** pokémons;
    - Between **(>=) 23ºC and (<) 27ºC** will retrieve **bug** pokémons;
    - Between **(>=) 27ºC and 33ºC** will retrieve **rock** pokémons;
    - Bigger than **(<) 33ºC** will retrieve **fire** pokémons;
    - **To any other temperature**, **normal** pokémons should be retrieved;
    - If it is **raining**, **eletric** pokémons will be retrieved, no matter the temperature.

> These rules are based oh the following challenge: *[Desafio Pokémon para Desenvolvedores](https://gitlab.com/enviabybus/weather-pokemon-test/-/tree/master/developer)*

_______________________________________________________

### **Weather**

To retrieve the weather conditions based on the city,  the microservice **World Weather** will be using the *[OpenWeatherMap API](https://openweathermap.org/api)*.

### **Technologies**
- This project technologies are:
    - Java 17;
    - Spring Boot 2.7.2;
    - Maven 4.0.0;
    - Swagger 2.9.2;
    - JPA;
    - MySQL Database;
- Architecture:
    - Microservices;

To be implemented:
- Docker;
- Front-End: 
    - Angular 11;
    - Typescript;

 

