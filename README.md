## Badges:

<a href="https://codeclimate.com/github/k0damaDEV/spring-cloud-example/maintainability"><img src="https://api.codeclimate.com/v1/badges/335f87918f06de3dd942/maintainability" /></a>

## Description:

Training project, which main goal was to practice with Spring Cloud. Maybe it would migrate to K8s sometime :P

## Java version

* Java 17

## Diagram

~~Stolen~~ implemented from Amigoscode Microservices course

![alt text](https://github.com/k0damaDEV/spring-cloud-example/blob/main/cloud-diagram.png?raw=true)

## Launch

All projects can be started via docker-compose, so all you need is:

```sh
git clone https://github.com/k0damaDEV/spring-cloud-example.git project-directory
cd project-directory
docker-compose up
```

Maybe you would have some issues if you will run this project in docker on ADM64 machine. If so - change `arm64` in main `pom.xml` to `amd64` and it should be started.
