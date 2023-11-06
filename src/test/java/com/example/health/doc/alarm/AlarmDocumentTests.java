package com.example.health.doc.alarm;

import com.example.health.doc.AbstractRestDocsTests;
import com.example.health.domain.alarm.api.AlarmController;
import com.example.health.domain.alarm.application.query.AlarmQueryService;
import com.example.health.domain.alarm.dto.AlarmDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlarmController.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
public class AlarmDocumentTests extends AbstractRestDocsTests {
    @MockBean
    private AlarmQueryService alarmQueryService;
    
    @Test
    @DisplayName("알람 전체 조회 API")
    void findAllAlarm() throws Exception{
        // given
        List<AlarmDto> response = Arrays.asList(AlarmDto.builder()
                                                .id(1L)
                                                .name("테스트 알람")
                                                .build());

        given(alarmQueryService.findAll()).willReturn(response);
        
        // when
        ResultActions result = this.mockMvc.perform(get("/alarms").accept(MediaType.APPLICATION_JSON));
        
        // then
        result.andExpect(status().isOk());
    }

}
