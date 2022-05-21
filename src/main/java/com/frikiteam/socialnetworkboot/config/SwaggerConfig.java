package com.frikiteam.socialnetworkboot.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .info(new Info()
            .title("Social Network Boot API")
            .description("Social Network Boot API")
            .version("1.0.0")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
            .externalDocs(new ExternalDocumentation()
          .description("Social Network Microservice developed with Java and Spring Boot")
          .url("https://github.com/FrikiEvents/social-network-boot"));
  }
}
