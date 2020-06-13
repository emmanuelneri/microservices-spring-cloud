## microservices-spring-cloud

![alt tag](https://github.com/emmanuelneri/microservices-spring-cloud/blob/master/architecture.jpeg)

#### Executando ambiente

1. ```sh docker-build.sh```
2. ```sh docker-infra-start.sh```
2. ```sh docker-cloud-start.sh```
3. ```sh docker-app-start.sh```

## Configurações das aplicações:
As configurações estão centralizadas na pasta [config-repo](https://github.com/emmanuelneri/microservices-spring-cloud/tree/master/config/config-repo/config-repo) do projeto ``config``, onde serão disponibilizadas pelo Spring Cloud Config no startup das aplicações.

As configurações seguem a seguinte hierarquia:
![alt tag](https://github.com/emmanuelneri/microservices-spring-cloud/blob/master/config-hierarquia.png)