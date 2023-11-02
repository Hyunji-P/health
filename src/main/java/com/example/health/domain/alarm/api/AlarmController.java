package com.example.health.domain.alarm.api;

import com.example.health.domain.alarm.application.query.AlarmQueryService;
import com.example.health.domain.alarm.domain.Alarm;
import com.example.health.domain.alarm.domain.AmPmType;
import com.example.health.domain.alarm.domain.Period;
import com.example.health.domain.alarm.domain.Schedule;
import com.example.health.domain.alarm.dto.AlarmDto;
import com.example.health.domain.alarm.repository.command.AlarmCommandRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
