package com.example.health.domain.alarm.api;

import com.example.health.domain.alarm.application.query.AlarmQueryService;
import com.example.health.domain.alarm.dto.AlarmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlarmController {
    private final AlarmQueryService alarmQueryService;

    @GetMapping("/alarms")
    public List<AlarmDto> findAlarms() {
        return alarmQueryService.findAll();
    }
}
