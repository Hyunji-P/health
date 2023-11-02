package com.example.health.domain.alarm.application.query;

import com.example.health.domain.alarm.dto.AlarmDto;

import java.util.List;

public interface AlarmQueryService {
    List<AlarmDto> findAll();
}
