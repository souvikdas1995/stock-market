# stock-market
This is backend application for stock-market


## Request body to create company :

{
  "ceo": "Rajesh Gopinathan",
  "companyName": "Tata Consultancy Services",
  "description": "global IT services, consulting and business solutions organization",
  "exchange": "BSE",
  "turnover": 200,
  "website": "https://www.tcs.com/"
}

## Request body to create stock :

{
  "companyCreation": {
    "companyCode": 1
  },
  "createdOn": "2022-05-28T05:35:02.587Z",
  "description": "TCS Stock 1",
  "price": 1000,
  "stockName": "TCS Stock 1"
}

## frontend
Frontend application is dockerized and image is available in https://hub.docker.com/repository/docker/souvikd95/stock-market-frontend

github link : https://github.com/souvikdas1995/stock-market-frontend

This frontend app image is being used in docker-compose of backend application.

## run with docker : 

To run just follow the below command from the root directory of backend app:

1. mvn clean install
2. docker-compose up --build
