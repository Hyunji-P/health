package com.example.health.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Schedule {
    private AmPmType amPm;

    private Integer hours;

    private Integer minutes;

    public Schedule(AmPmType amPm, Integer hour, Integer minute) {
        this.amPm = amPm;
        this.hours = hour;
        this.minutes = minute;
    }
}
