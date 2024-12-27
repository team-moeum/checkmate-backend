package com.checkmate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi authorizeApi() {
        return GroupedOpenApi.builder()
                .group("authorize")
                .pathsToMatch("/**")
                .pathsToExclude("/home/health", "/api/v1/member/login-state", "/api/v1/member/social-login", "/api/v1/jwt/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/home/health", "/api/v1/member/login-state", "/api/v1/member/social-login", "/api/v1/jwt/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("REST API Docs")
                        .description("REST API 명세서입니다.")
                        .version("0.1"));
    }
}
