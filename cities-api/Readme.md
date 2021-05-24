# Cities API

Descrição: Api utilizada para consultar cidades e estados do Brasil e calcular a distância entre duas cidades.

## EndPoints

 * Listar todas as Cidades
    	``https://localhost:8080/cities``

 * Listar Todos os Estados
    	
   ``https://localhost:8080/states``
   
 * Listar Todos os Países

   ``https://localhost:8080/countries``

   1. Pesquisar por Nome(cities, states, countries)
      ``/name=PARTE_DO_NOME_DESEJADO``

   2. Pesquisa Por Id(cities, states, countries)

      ``/name=ID``

* Calcular a distância entre duas cidades

     * Método byPoints(Em milhas)
          * ``localhost:8080/distances/by-points?from=ID_CIDADE1&to=ID_CIDADE2``
     * Método byCube(Em metros)
          * ``localhost:8080/distances/by-cube?from=ID_CIDADE1&to=ID_CIDADE2``

     ​	



## Requirements

* Windows
* Git
* Java 8
* Postgres DB (não foi utilizado Docker porque só funciona acima do Windows 10)
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

Instalação padrão do banco

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```psql -h localhost -U {usuario} {nomeBanco} 

\i /caminho/pasta/pais.sql

\i /caminho/pasta/cidade.sql

\i /caminho/pasta/estado.sql

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

* [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)



