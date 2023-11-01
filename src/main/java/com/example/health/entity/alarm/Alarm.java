package com.example.health.entity.alarm;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Alarm {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Period period;

    @ElementCollection
    @CollectionTable(name = "schedule", joinColumns =
        @JoinColumn(name = "alarm_id")
    )
    private List<Schedule> schedules = new ArrayList<>();

    public Alarm(String name, Period period) {
        this.name = name;
        this.period = period;
    }

    public void changeAlarm(String name, Period period, List<Schedule> schedules) {
        this.name = name;
        this.period = period;
        this.schedules = schedules;
    }
}
