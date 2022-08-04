
## **Pokédex**

This is a training project developed using Spring Boot, MySql, JPA, Docker, Adminer, Typescript, Angular 11 and Microservices.
_____________________________
### How can I test?

> You need to have [Docker](https://www.docker.com/products/docker-desktop/) installed on your machine to test this project.

This project uses Docker, and it will automatically build the application's services together with the database and it's data.
- Clone this repository on your machine;
- Open command line(cmd) and navigate to where you have cloned the repository on your machine. 
    > On windows, you can use file explorer, open the project folder, click on the path bar and type "cmd". It will open cmd directly on the folder.

However, to be able to use the Wolrd Weather service, it is necessary to provide an api key from OpenWeatherMap API.
Follow the above steps:
- Enter [OpenWeatherMap - Sign In](https://home.openweathermap.org/users/sign_in);
- Click on **"Create an Account"** if you don't have one;
- After you are logged, go to the tab **API Keys**;
- Copy the key;
- Open **world-weather** folder and search for the file **.env-example**;
- Open it and place your API key after **apiId=**;
- Rename the file from **.env-example** to **.env**;
- Use **docker-compose up** to build the project;

Explore the enpoints on [Swagger](http://localhost:8080/swagger).
> You can also use [Postman](https://www.postman.com/downloads/) and test the endpoints in there.

____________________________
### **Objective**
User will be able to:
 - Register new Pokémon;
 - Retrieve the list of registered pokémons;
 - Edit an previous Pokémon;
 - Delete an existing Pokémon;
 - Search the species and skills for that Pokemon;
 - Provide a city name and receive a list of pokemons that will be probably appearing in there based on the current weather and pokémon type.

### Rules for retrieving the pokémons weather based

- Cities where the temperature is:
    - Less then **(<) 5ºC**, will retrieve **ice** pokémons;
    - Between **(>=) 5ºC and (<) 10ºC** will retrieve **water** pokémons;
    - Between **(>=) 12ºC and (<) 15ºC** will retrieve **grass** pokémons;
    - Between **(>=) 15ºC and (<) 21ºC** will retrieve **ground** pokémons;
    - Between **(>=) 23ºC and (<) 27ºC** will retrieve **bug** pokémons;
    - Between **(>=) 27ºC and 33ºC** will retrieve **rock** pokémons;
    - Bigger than **(<) 33ºC** will retrieve **fire** pokémons;
    - **To any other temperature**, **normal** pokémons should be retrieved;
    - If it is **raining**, **eletric** pokémons will be retrieved, no matter the temperature.

> These rules are based on the following challenge: *[Desafio Pokémon para Desenvolvedores](https://gitlab.com/enviabybus/weather-pokemon-test/-/tree/master/developer)*

_______________________________________________________

### **Weather**

To retrieve the weather conditions based on the city,  the microservice **World Weather** will be using the *[OpenWeatherMap API](https://openweathermap.org/api)*.

### **Technologies**
- This project technologies are:
    - Java 11;
    - Spring Boot 2.7.2;
    - Maven 3.8.4;
    - Swagger 2.9.2;
    - JPA;
    - MySQL Database;
- Architecture:
    - Microservices;

To be implemented:
- Front-End: 
    - Angular 11;
    - Typescript;

 

