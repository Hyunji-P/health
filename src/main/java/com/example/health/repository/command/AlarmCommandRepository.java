package com.example.health.repository.command;

import com.example.health.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmCommandRepository extends JpaRepository<Alarm, Long> {
}
