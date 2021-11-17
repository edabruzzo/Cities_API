# Projeto Digital Innovation One Cities API
## Projeto entregue como requisito parcial do BootCamp TQI - JAVA DEVELOPER

### Emmanuel de Oliveira Abruzzo - Novembro/2021
    Deploy do projeto DIGITAL INNOVATION ONE - BOOTCAMP - TQI-JAVA-DEVELOPER - NOV/2021

#### API SPRING REST PARA CÁLCULO DE DISTÂNCIA ENTRE CIDADES COM BASE NO RAIO DA TERRA - SUPORTE A CÁLCULO COM DIFERENTES MÉTODOS E MEDIDAS
+ https://fierce-atoll-34490.herokuapp.com/    deployed to Heroku
#### GITHUB:
+ https://github.com/edabruzzo/
#### LINKEDIN:
+ https://www.linkedin.com/in/emmanuel-abruzzo-8ba80a36/
#### DISCORD - DIO
+ Discord: https://discord.gg/AWxMaerJ
#### DIGITAL INNOVATION ONE
+ https://digitalinnovation.one/
+ #### Video deploy
+ https://youtu.be/6Vd3WYr5r3E


#Desenvolvimento #Developer
#Spring
#JAVA
#DigitalInnovationOne #DigitalInnovation




## Endpoints

#### Lista cidades próximas de uma determinada cidade (nomeCidadeFrom) num determinado raio (raioDistancia)
+ https://fierce-atoll-34490.herokuapp.com/distances/Curitiba/Salvador
+ http://localhost:8080/distances/{nomeCidadeFrom}/{raioDistancia}

#### Calcula distância entre cidades baseadas em pontos
+ https://fierce-atoll-34490.herokuapp.com/distances/by-point?from=10&to=20
+ http://localhost:8080/distances/by-point?from=idCidade1&to=idCidade2

#### Calcula distância entre cidades baseadas em Cube e coordenadas de Latitude e Longitude
    X1 = Latitude da cidade 1 / Y1 = Longitude cidade 1
    X2 = Latitude da cidade 2 / y2 = Longitude cidade 2
+ https://fierce-atoll-34490.herokuapp.com/distances/by-cube?x1=lat_cidade1&y1=long_cidade1&x2=lat_cidade2&y2=long_cidade2
+ http://localhost:8080/distances/by-cube?x1=lat_cidade1&y1=long_cidade1&x2=lat_cidade2&y2=long_cidade2

#### Calcula a distância entre duas cidades por Matemática pura em três opções de unidade de medida
    
    O cálculo é executado utilizando medidas de raio da Terra e fórmulas matemáticas
    O parâmetro unidade de medida é opcional e, caso não especificado, será calculada a distância em KM
    
##### Devolve o cálculo em KM
+ https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/São Paulo/Curitiba/kilometers
+ localhost:8080/distances/calcularPorMatematicaPura/São Paulo/Curitiba/kilometers

##### Devolve o cálculo em uma das medidas suportadas  
    O que permite que o usuário passe o nome do Enum EarthRadius em letra minúscula é o StringToEnumEarthRadiusConverter
    Unidades de medida suportadas: metros ou  kilômetros ou milhas
+ https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/Curitiba/Salvador/{METERS/meters ou  KILOMETERS/kilometers ou MILES/miles}
+ http://localhost:8080/distances/calcularPorMatematicaPura/Curitiba/Salvador/{METERS/meters ou  KILOMETERS/kilometers ou MILES/miles}



#### EXPLORAÇÃO DE CONCEITOS DE ORIENTAÇÃO A OBJETO

    O projeto explora também o conceito de sobrecarga de métodos e contrutores
    Foram declarados métodos com o mesmo nome e assinaturas diferentes na camada de serviço 
    Foi criada uma interface na camada serviço para estabelecer um contrato entre a classe de cálculo que a implementa 
    E realizada de fato as operações para cálculo, invocando métodos na camada repositório
    
    @Override
    public Double calculaDistanciaEntreCidadesUsandoMatematicaPura(Long idCidade1, Long idCidade2, EarthRadius unit) {

    @Override
    public Double calculaDistanciaEntreCidadesUsandoMatematicaPura(String nomeCidade1, String nomeCidade2, EarthRadius unit) {


#### Exploração de declaração de @NativeNamedQueries nas Classes de Entidade, na camada modelo  

    O projeto explora também o conceito de Queries nomeadas declaradas na 
    Classe de entidade e também Queries declaradas na camada Repository (DAO)


## Requirements

* Linux
    Meu sistema já é Ubuntu (release "Bionic")
* Git
* Java 8
* Docker
  
* IntelliJ Community ou NetBeans
  * Desenvolvido inicialmente no NetBeans e depois migrei para o IntelliJ Idea
  * Adorei o IntelliJ, pois já estava muito familiarizado com o PyCharm da JetBrains
  * Sempre desenvolvi em NetBeans, mas depois deste BootCamp, começo a considerar migrar para o IntelliJ

* Heroku CLI

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)


#### Atenção ! Se você possui o Postgresql instalado na maquina local das duas uma:
1) Terá que parar o serviço do postgres que roda na porta 5432 antes de rodar a imagem docker
```shell script
/etc/init.d/postgres stop
```

3) Mudar a porta exposta pela imagem para não mapear a 5432 que já estará em uso no seu banco local

#### Escrevi um artigo na DIO a respeito do conflito de portas:
+ https://digitalinnovation.one/artigos/avoid-port-conflicts-when-configuring-postgresql-image-from-docker-on-your-local-machine-with-another-postgresql-instance


```shell script
cd /home/$USER/NetBeansProjects/DigitalOne_2/project_cities_api/scripts/PostgreSQL &&
/etc/init.d/postgresql stop && sudo docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

cd tmp/ && for file in *.sql; do psql -U postgres_user_city -h localhost -p 5432 -d cities -f $file; done

psql -h localhost -U postgres_user_city cities

# Transportadas para um arquivo *.sql para serem executadas no loop for acima
--CREATE EXTENSION cube; 
--CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

#### Consulta de cidades próximas de outra em determinado raio de distância

```roomsql
select distinct c2.id, c2.nome, (c1.lat_lon <@> c2.lat_lon) as di
from public.cidade c1 
	inner join public.cidade c2
		on (c1.lat_lon <@> c2.lat_lon) < 100
where c1.nome ilike 'São Paulo';
```


Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

### Hibernate-spatial
    Criei uma branch e profile específicos apenas para explorar o hibernate-spatial 
    como alternativa para lidar com tipos Geoespaciais no PostgreSQL, no momento de 
    mapear entidades e acessar os dados persistidos com tipo Point, Geometry, etc


## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ MAVEN Project
  + Devido à minha familiaridade, optei por desenvolver e construir o projeto e gerenciar dependências com Maven
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver
    Versão: 42.2.24
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

## Code Quality

### PMD

+ https://pmd.github.io/pmd-6.8.0/index.html

### Checkstyle

+ https://checkstyle.org/

+ https://checkstyle.org/google_style.html

+ http://google.github.io/styleguide/javaguide.html

```shell script
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```


### OUTRAS REFERÊNCIAS ÚTEIS

#### SPRING REST APPLICATION
+  https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html
+  https://spring.io/guides/gs/rest-service/
+  https://spring.io/guides
+  https://www.tutorialspoint.com/spring/calling_stored_procedure.htm
+  https://www.tutorialspoint.com/spring_boot/spring_boot_consuming_restful_web_services.htm


#### GIT PULL-REQUEST TUTORIAL
+ https://www.digitalocean.com/community/tutorials/how-to-create-a-pull-request-on-github

#### Discussão sobre injeção de dependência
+ https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html

+ "O Spring automaticamente fornece a injeção de dependência. Este exemplo não está usando a anotação @Autowired pois não é mais considerado
uma boa prática para injeção de dependência de atributos obrigatórios. Desde a versão 4 do
Spring a prática recomendada é o uso de injeção de dependência por construtor
(as IDEs mais modernas inclusive apresentam um alerta quando fazemos o uso do @Autowired)."


#### SHELL JAVA
+ https://stackabuse.com/executing-shell-commands-with-java/


#### STRING FORMAT
+ https://www.javatpoint.com/java-string-format


#### TESTE SPRING
+ https://spring.io/guides/gs/testing-web/
+ https://www.baeldung.com/spring-boot-testing
+ https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
+ https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm


#### GEOMAPPING - POSTGRESQL X HIBERNATE
+ https://stackoverflow.com/questions/27624940/map-a-postgis-geometry-point-field-with-hibernate-on-spring-boot
+ https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#spatial 
+ https://www.baeldung.com/hibernate-spatial
+ https://stackoverflow.com/questions/31440496/hibernate-spatial-5-geometrytype
+ https://github.com/Wisienkas/springJpaGeo
+ https://www.postgresql.org/docs/12/functions-geometry.html

#### USANDO NamedQueries ou NamedNativeQueries COM SPRING DATA
+ https://thorben-janssen.com/spring-data-jpa-named-queries/
+ https://howtodoinjava.com/jpa/jpa-native-query-example-select/
+ https://zetcode.com/springboot/datajpanamedquery/


#### INTERCEPTORS SPRING X CDI 
+ https://rhuanrocha.net/2019/01/06/creating-logger-with-aop-using-cdi-interceptor/
+ https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm
+ https://stackoverflow.com/questions/31082981/spring-boot-adding-http-request-interceptors

#### Conversor String para Enum para Receber parametro Minusculo
+ https://www.baeldung.com/spring-enum-request-param
+ https://www.baeldung.com/spring-type-conversions

#### Deploy da aplicação Springboot Maven no Heroku
Usando o plugin Heroku do Maven
```
$ mvn clean dependency:copy-dependencies package heroku:deploy

[INFO] -----> Creating build...
[INFO]        - file: /tmp/heroku-deploy14168471124361201653source-blob.tgz
[INFO]        - size: 131MB
[INFO] -----> Uploading build...
^[[5F[INFO]        - success
[INFO] -----> Deploying...
[INFO] remote: 
[INFO] remote: -----> Building on the Heroku-20 stack
[INFO] remote: -----> Using buildpack: heroku/jvm
[INFO] remote: -----> heroku-maven-plugin app detected
[INFO] remote: -----> Installing JDK 1.8... done
[INFO] remote: -----> Discovering process types
[INFO] remote:        Procfile declares types -> web
[INFO] remote: 
[INFO] remote: -----> Compressing...
[INFO] remote:        Done: 183.6M
[INFO] remote: -----> Launching...
[INFO] remote:        Released v30
[INFO] remote:        https://fierce-atoll-34490.herokuapp.com/ deployed to Heroku
[INFO] remote: 
[INFO] -----> Done
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  04:41 min
[INFO] Finished at: 2021-11-17T09:53:40-03:00
[INFO] ------------------------------------------------------------------------


$ heroku logs --tail


2021-11-17T12:48:12.078750+00:00 heroku[run.7699]: State changed from up to complete
2021-11-17T12:53:22.000000+00:00 app[api]: Build started by user emmanuel.oliveira3@gmail.com
2021-11-17T12:53:38.991791+00:00 app[api]: Release v30 created by user emmanuel.oliveira3@gmail.com
2021-11-17T12:53:38.991791+00:00 app[api]: Deploy 0.0.1-SNAPSHOT by user emmanuel.oliveira3@gmail.com
2021-11-17T12:53:39.000000+00:00 app[api]: Build succeeded
2021-11-17T12:53:40.044875+00:00 heroku[web.1]: State changed from crashed to starting
2021-11-17T12:53:45.766843+00:00 heroku[web.1]: Starting process with command `java -Dserver.port=22517 -jar -Dspring.profiles.active=heroku target/project_cities_api-0.0.1-SNAPSHOT.jar`
2021-11-17T12:53:47.956815+00:00 app[web.1]: Setting JAVA_TOOL_OPTIONS defaults based on dyno size. Custom settings will override them.
2021-11-17T12:53:47.964565+00:00 app[web.1]: Picked up JAVA_TOOL_OPTIONS: -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8
2021-11-17T12:53:49.282528+00:00 app[web.1]: 
2021-11-17T12:53:49.282650+00:00 app[web.1]: .   ____          _            __ _ _
2021-11-17T12:53:49.282692+00:00 app[web.1]: /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
2021-11-17T12:53:49.282733+00:00 app[web.1]: ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
2021-11-17T12:53:49.282777+00:00 app[web.1]: \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
2021-11-17T12:53:49.282815+00:00 app[web.1]: '  |____| .__|_| |_|_| |_\__, | / / / /
2021-11-17T12:53:49.282852+00:00 app[web.1]: =========|_|==============|___/=/_/_/_/
2021-11-17T12:53:49.283984+00:00 app[web.1]: :: Spring Boot ::                (v2.5.6)
2021-11-17T12:53:49.284012+00:00 app[web.1]: 
2021-11-17T12:53:49.439824+00:00 app[web.1]: 2021-11-17 12:53:49.437  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : Starting ProjectCitiesApiApplication v0.0.1-SNAPSHOT using Java 1.8.0_312-heroku on 6618f368-20b2-4544-85a9-782d23670d34 with PID 4 (/app/target/project_cities_api-0.0.1-SNAPSHOT.jar started by u9248 in /app)
2021-11-17T12:53:49.440541+00:00 app[web.1]: 2021-11-17 12:53:49.440  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : The following profiles are active: heroku
2021-11-17T12:53:50.379161+00:00 app[web.1]: 2021-11-17 12:53:50.378  INFO 4 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-11-17T12:53:50.468044+00:00 app[web.1]: 2021-11-17 12:53:50.467  INFO 4 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 63 ms. Found 3 JPA repository interfaces.
2021-11-17T12:53:51.169628+00:00 app[web.1]: 2021-11-17 12:53:51.169  INFO 4 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 22517 (http)
2021-11-17T12:53:51.181191+00:00 app[web.1]: 2021-11-17 12:53:51.181  INFO 4 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-11-17T12:53:51.181338+00:00 app[web.1]: 2021-11-17 12:53:51.181  INFO 4 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.54]
2021-11-17T12:53:51.235918+00:00 app[web.1]: 2021-11-17 12:53:51.235  INFO 4 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-11-17T12:53:51.236045+00:00 app[web.1]: 2021-11-17 12:53:51.235  INFO 4 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1713 ms
2021-11-17T12:53:51.480657+00:00 app[web.1]: 2021-11-17 12:53:51.479  INFO 4 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-11-17T12:53:51.539039+00:00 app[web.1]: 2021-11-17 12:53:51.538  INFO 4 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final
2021-11-17T12:53:51.851441+00:00 app[web.1]: 2021-11-17 12:53:51.851  INFO 4 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2021-11-17T12:53:51.957733+00:00 app[web.1]: 2021-11-17 12:53:51.957  INFO 4 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-11-17T12:53:52.297792+00:00 app[web.1]: 2021-11-17 12:53:52.297  INFO 4 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-11-17T12:53:52.340627+00:00 app[web.1]: 2021-11-17 12:53:52.340  INFO 4 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
2021-11-17T12:53:53.089442+00:00 app[web.1]: 2021-11-17 12:53:53.089  INFO 4 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-11-17T12:53:53.321481+00:00 app[web.1]: 2021-11-17 12:53:53.321  INFO 4 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-11-17T12:53:54.136065+00:00 app[web.1]: 2021-11-17 12:53:54.135  WARN 4 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2021-11-17T12:53:54.789421+00:00 app[web.1]: 2021-11-17 12:53:54.789  INFO 4 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 22517 (http) with context path ''
2021-11-17T12:53:54.801433+00:00 app[web.1]: 2021-11-17 12:53:54.801  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : Started ProjectCitiesApiApplication in 6.057 seconds (JVM running for 6.837)
2021-11-17T12:53:55.095750+00:00 heroku[web.1]: State changed from starting to up

```

+ https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
+ https://stackoverflow.com/questions/32490217/java-web-app-on-heroku-unable-to-access-jarfile
+ http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
+ https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku


#### Heroku DB Migrations on Release Phase
+ https://devcenter.heroku.com/articles/running-database-migrations-for-java-apps
+ https://devcenter.heroku.com/articles/release-phase

#### Conexão Banco de Dados PostgreSQL Heroku Add-on
    heroku pg:psql postgresql-clean-54438 --app fierce-atoll-34490

    Outro meio de se conectar diretamente com psql com as credenciais de banco e host fornecidas pelo próprio Heroku