package com.example.health.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Alarm {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Period period;

    @ElementCollection
    @CollectionTable(name = "schedule")
    private List<Schedule> schedules = new ArrayList<>();
}
