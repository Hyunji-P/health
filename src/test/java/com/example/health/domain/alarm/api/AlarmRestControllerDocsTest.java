package com.example.health.domain.alarm.api;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.example.health.documentation.AbstractRestDocsTests;
import com.example.health.domain.alarm.application.query.AlarmQueryService;
import com.example.health.domain.alarm.dto.AlarmDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static com.example.health.documentation.ApiDocumentUtils.getDocumentRequest;
import static com.example.health.documentation.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlarmController.class)
public class AlarmRestControllerDocsTest extends AbstractRestDocsTests {
    @MockBean
    private AlarmQueryService alarmQueryService;

    @DisplayName("알람 전체 조회")
    @Test
    void testAlarmFindAll() throws Exception{
        // given
        AlarmDto alarm1 = AlarmDto.builder()
                .id(1L)
                .name("alarm1")
                .build();

        AlarmDto alarm2 = AlarmDto.builder()
                .id(2L)
                .name("alarm2")
                .build();
        List<AlarmDto> response = Arrays.asList(alarm1, alarm2);

        given(alarmQueryService.findAll()).willReturn(response);

        // when
        ResultActions result = mockMvc.perform(get("/alarms").accept(APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                //REST Docs 용
                .andDo(document("find-all-alarm",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("[].id").type(NUMBER).description("아이디"),
                                fieldWithPath("[].name").type(STRING).description("알람명")
                        )
                ))
                //OAS 3.0 - Swagger
                .andDo(MockMvcRestDocumentationWrapper.document("find-all-alarm",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        resource(ResourceSnippetParameters.builder()
                                .responseFields(
                                        fieldWithPath("[].id").type(NUMBER).description("아이디"),
                                        fieldWithPath("[].name").type(STRING).description("알람명"))
                                .build())));
        ;
    }
}
