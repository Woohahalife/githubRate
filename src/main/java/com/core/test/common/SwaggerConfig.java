package com.core.test.common;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    String root = "com.core.test";
    String[] paths = {
            root
    };

    @Bean
    public GroupedOpenApi getEntireApi() {
        return GroupedOpenApi.builder()
                .group("Entire")
                .packagesToScan(paths)
                .build();
    }
}
