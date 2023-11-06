package com.example.health.doc.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static com.example.health.doc.util.ApiDocumentUtils.getDocumentRequest;
import static com.example.health.doc.util.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

@TestConfiguration
public class RestDocsConfiguration {

    @Bean
    public RestDocumentationResultHandler write() {
        return MockMvcRestDocumentation.document(
                "{class-name}/{method-name}",
                getDocumentRequest(),
                getDocumentResponse()
        );
    }
}
