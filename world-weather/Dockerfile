FROM maven:3.8.4-openjdk-11
WORKDIR /world-weather
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run