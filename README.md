# Gowtham-city

### Prerequisites

- Java 8 or 11 & maven

- Okta authorization layer which can be create for free here(https://developer.okta.com/signup/) and after 
login we need to create a new Web Application in Okta’s dashboard (Applications > Add 
    Application).
    
- Install docker (https://docs.docker.com/docker-for-mac/install/)

- PostgreSQL 
```jshelllanguage
docker pull postgres:11
docker run --name dev-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres:11
# CREATE db coursedb
docker exec dev-postgres psql -U postgres -c"CREATE DATABASE coursedb" postgres
```




##### Build Microservices in Spring with Docker

Services involved in this project are 

- Parent Service
    - Config 
        - To remove any trace of configuration values in the project’s source code
    - Discovery
        - To communicate between microservices (http://localhost:8761)
    - School-Service
        - Persistence layer and business rules
    - School-UI
        - User interface that utilizes School Service (http://localhost:8080)

## Run

- Build the images 

```jshelllanguage
cd config && ./mvnw clean install
cd ../discovery && ./mvnw clean install
cd .. && ./mvnw clean install
cd school-ui && ./mvnw clean install
```

- Start all your containers 
```jshelllanguage
docker-compose up -d
```

- Optional : We can select our profile to use from compose as below 
    - production
    - test 
    
    sample config
   
   ```yaml
   school-ui:
     image: dev.gowtham.com/microservice-school-ui:0.0.1-SNAPSHOT
     environment:
       - JAVA_OPTS=
         -DEUREKA_SERVER=http://discovery:8761/eureka
         -Dspring.profiles.active=production
     restart: on-failure
     depends_on:
       - discovery
       - config
     ports:
       - 8080:8080
   ```

###### Roadmap:  

- Flyway 
- Profile for nosql, postgres and mysql
- User access roles from okta groups 
- Datadog
- Sentry
- K8s
- Tests: PBT, Contract based and Behaviour
