# microservices application example

The experimental project which shows a simple microservice architecture with Spring Cloud. 

To run the application you necessary to install docker.

### Build application
mvn clean install

### Run in docker

docker-compose up -d

Application UI starts on localhost:3000

### API Gateway service
API Gateway service is located on http://localhost:9000 
The main aim the API gateway is to route request to appropriate services.

In the UI user can switch between two versions of API.
v1 - static service. It means when a user clicks on "Book ticket" button "ticketId" in response always will be 10.
v2 - dynamic service. It means "ticketId" will be generated based on timestamp.  
 