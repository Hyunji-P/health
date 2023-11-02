package com.example.health.domain.alarm.repository.query;

import com.example.health.domain.alarm.domain.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlarmQueryRepository extends JpaRepository<Alarm, Long>, AlarmQueryRepositoryCustom {
    Optional<Alarm> findByName(String name);
}
