package com.example.health.domain.alarm.api;

import com.example.health.domain.alarm.application.query.AlarmQueryService;
import com.example.health.domain.alarm.domain.Alarm;
import com.example.health.domain.alarm.domain.AmPmType;
import com.example.health.domain.alarm.domain.Period;
import com.example.health.domain.alarm.domain.Schedule;
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
    public List<Alarm> findAlarms() {
        return alarmQueryService.findAll();
    }

    /**
     * spring rest docs 테스트를 위한 init 설정
     * todo: 테스트 후 삭제 예정
     */
    @Component
    @RequiredArgsConstructor
    @Transactional
    static class Init{
        private final AlarmCommandRepository alarmCommandRepository;
        @PostConstruct
        public void init() {
            Schedule morning = new Schedule(AmPmType.AM, 8, 30);
            Schedule lunch = new Schedule(AmPmType.PM, 12, 00);
            Schedule dinner = new Schedule(AmPmType.PM, 20, 20);

            LocalDate startDate = LocalDate.of(2023, 11, 01);
            LocalDate endDate = LocalDate.of(2023, 11, 03);
            Period period = new Period(startDate, endDate);

            Alarm alarm = new Alarm("테스트 알람", period);
            alarm.getSchedules().add(morning);
            alarm.getSchedules().add(lunch);
            alarm.getSchedules().add(dinner);

            alarmCommandRepository.save(alarm);
        }
    }
}
