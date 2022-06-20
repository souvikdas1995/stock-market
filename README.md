# stock-market
This is a backend application for stock-market written in Java 11 and Spring Boot Rest Api Microservice

## technology and tools used :

Java 11

Spring Boot

Apache Kafka

Mongo DB

MySQL



## Request body to create company :

{
  "ceo": "Brian Humphries",
  "companyName": "Cognizant",
  "description": "global IT services, consulting and business solutions organization",
  "exchange": "BSE",
  "turnover": 200,
  "website": "https://www.cognizant.com/"
}

## Request body to create stock :

{
  "companyCreation": {
    "companyCode": 1
  },
  "createdOn": "2022-05-28T05:35:02.587Z",
  "description": "Cognizant Stock Description",
  "price": 50000,
  "stockName": "Cognizant Stock Name"
}

## frontend
Frontend application is dockerized and image is available in https://hub.docker.com/repository/docker/souvikd95/stock-market-frontend

github link : https://github.com/souvikdas1995/stock-market-frontend

This frontend app image is being used in docker-compose of backend application.

## run with docker : 

To run just follow the below command from the root directory of backend app:

1. mvn clean install
2. docker-compose up --build

## some snapshots of cqrs microservice swagger : 

### Projections : localhost:8081//swagger-ui.html
![snap5](https://user-images.githubusercontent.com/32546790/174550237-90444f01-6eee-4fd6-93e6-fef036819825.PNG)

### Aggregates : localhost:8082//swagger-ui.html
![snap6](https://user-images.githubusercontent.com/32546790/174551025-e0d92207-fee9-44b3-8276-7ca5ddb5c787.PNG)


