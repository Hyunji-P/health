package com.example.health.domain.alarm.application.query;

import com.example.health.domain.alarm.domain.Alarm;
import com.example.health.domain.alarm.dto.AlarmDto;
import com.example.health.domain.alarm.repository.query.AlarmQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlarmQueryServiceImpl implements AlarmQueryService{
    private final AlarmQueryRepository alarmQueryRepository;

    @Override
    public List<AlarmDto> findAll() {
        return alarmQueryRepository.findAllAlarm();
    }
}
