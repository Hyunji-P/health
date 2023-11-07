package com.example.health.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Health",
                version = "v2023.11.07",
                description = """
                        테스트!!!!
                        """
        )
)
@Configuration
public class SpringDocOpenApiConfig {
}
