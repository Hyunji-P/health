package com.example.health.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    private String amPm;

    private Integer hour;

    private Integer minute;
}
