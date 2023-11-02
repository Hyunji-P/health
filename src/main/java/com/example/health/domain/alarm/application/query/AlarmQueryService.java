package com.example.health.domain.alarm.application.query;

import com.example.health.domain.alarm.domain.Alarm;

import java.util.List;

public interface AlarmQueryService {
    List<Alarm> findAll();
}
