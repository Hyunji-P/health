package com.example.health.repository.command;

import com.example.health.entity.alarm.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmCommandRepository extends JpaRepository<Alarm, Long> {
}
