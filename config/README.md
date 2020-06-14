## Config - Spring Cloud Config

Obs: Como os arquivos são carregados da pasta local é necessário iniciar o projeto com o profile **native** 

#### Endpoints
- Retornar configurações gerais: ``curl -X "GET" "http://localhost:8888/application/default"``
- Retornar configurações da aplicação **customer** no profile **docker**``curl -X "GET" "http://localhost:8888/customer/docker"``
- Criptograr property ```curl localhost:8888/encrypt -d mysecret```