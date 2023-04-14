package com.app.story.documentation;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI expenseAPI() {
        return new OpenAPI()
                .info(new Info().title("News Story API")
                        .description("API for News Story Application")
                        .version("v0.0.1")
                        .license(new License().name("License Version 2.0").url("http://dev-amrit.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github Documentation")
                        .url("https://github.com/AmritcsAdhikari/news-story-api.git"));
    }
}
