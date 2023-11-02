package com.example.health.domain.alarm.repository.query;

import com.example.health.domain.alarm.dto.AlarmDto;

import java.util.List;

public interface AlarmQueryRepositoryCustom {
    List<AlarmDto> findAllAlarm();
}
