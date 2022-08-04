FROM maven:3.8.4-openjdk-11
WORKDIR /pokedex
COPY . .
RUN mvn clean install
CMD sleep 15 && mvn spring-boot:run