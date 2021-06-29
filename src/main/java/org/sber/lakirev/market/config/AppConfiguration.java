package org.sber.lakirev.market.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;

import java.util.Collections;

@Configuration
public class AppConfiguration {

    //Swagger configuration
    /*@Bean
    public GroupedOpenApi publicProductApi() {
        return GroupedOpenApi.builder()
                .group("Products")
                .pathsToMatch("/rest/market**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}")String appDescription,
                                 @Value("${application-version}")String appVersion) {
        return new OpenAPI().info(new Info().title("Application API")
                .version(appVersion)
                .description(appDescription)
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org"))
                .contact(new Contact().name("username")
                        .email("andrey@noobbox.ru")))
                .servers(Collections.singletonList(new Server().url("http://localhost:8080")
                        .description("Dev service")));
    }*/



}
