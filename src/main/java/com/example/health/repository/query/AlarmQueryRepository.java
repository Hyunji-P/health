package com.example.health.repository.query;

import com.example.health.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlarmQueryRepository extends JpaRepository<Alarm, Long> {
    Optional<Alarm> findByName(String name);
}
