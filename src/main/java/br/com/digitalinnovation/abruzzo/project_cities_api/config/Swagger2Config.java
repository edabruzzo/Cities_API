package br.com.digitalinnovation.abruzzo.project_cities_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe que permite a configuração do Swagger para documentação da API
 *
 * @link https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 * @link https://github.com/aillamsun/spring-boot-docker-example/blob/master/src/main/java/com/sung/config/Swagger2Config.java
 * @link https://hantsy.gitbook.io/build-a-restful-app-with-spring-mvc-and-angularjs/swagger
 * @link https://swagger.io/resources/articles/documenting-apis-with-swagger/
 * @link https://www.baeldung.com/spring-circular-view-path-error
 * @author Emmanuel Abruzzo
 *  *
 */
@Configuration
@EnableSwagger2
@Profile(value = {"desenvolvimento", "heroku"})
public class Swagger2Config {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.digitalinnovation.abruzzo.project_cities_api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo(){
        ApiInfo build = new ApiInfoBuilder()
                .title("API de Consulta de cidades")
                .description("API que permite o cálculo de distância entre cidades no Brasil, " +
                        "com base em diferentes técnicas e consulta de cidades em raio de distância" +
                        " de uma cidade alvo")
                .contact(new Contact("Emmanuel Abruzzo","https://github.com/edabruzzo",
                        "emmanuel.oliveira3@gmail.com"))
                .build();
        return build;
    }

}
