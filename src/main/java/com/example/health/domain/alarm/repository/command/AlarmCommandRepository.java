package com.example.health.domain.alarm.repository.command;

import com.example.health.domain.alarm.domain.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmCommandRepository extends JpaRepository<Alarm, Long> {
}
