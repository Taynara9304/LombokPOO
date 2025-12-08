# LombokPOO

Para utilizar o sitema é necessário criar o banco de dados mySql aula.

Execute:
```
cd cars-main/
```

```
./mvnw spring-boot:run
```

## Criar motorista e passageiro
Primeiro, utilize as seguintes rotas com o método POST para criar um motorista e passageiro:
- Motorista: http://localhost:8080/drivers

Exemplo:
```
  {
    "name": "Pedro",
    "birthDate": "2003-03-03",
    "email": "pedro@gmail.com",
    "cpf": "111.222.333-55",
    "placa": "ABC1D23",
    "cnh": "12345678910",
    "anoCarro": 2001,
    "comentario": "Quero conhecer novos amigos!"
  }
```
- Passageiro: http://localhost:8080/passenger

Exemplo:
```
  {
    "name": "Laura",
    "email": "laura@gmail.com"
  }
```

## Solicitar viagem

Depois, para criar uma vigem, utilize o seguinte endereço: http://localhost:8080/travels

Exemplo:
```
{
  "origem": "Cascavel",
  "destino": "Curitiba",
  "passenger": {
    "id": 1
  }
}
```

## Aceitar, recusar e terminar uma corrida
Para aceitar uma corrida, utilize o endereço com o método PATCH: http://localhost:8080/travels/idCorrida/accept/idMotorista

Para recusar uma corrida, utilize o endereço com o método PATCH: http://localhost:8080/travels/idCorrida/refuse/idMotorista

Para finalizar uma corrida, utilize o endereço com o método PATCH: http://localhost:8080/travels/idCorrida/finish/idMotorista

Exemplo:
```
http://localhost:8080/travels/1/accept/1
```

```
http://localhost:8080/travels/1/refuse/1
```

```
http://localhost:8080/travels/1/finish/1
```

Obs.: É necessário fazer nessa ordem, criar, aceitar/recusar e por fim terminar.