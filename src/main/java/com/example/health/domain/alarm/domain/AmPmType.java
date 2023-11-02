package com.example.health.domain.alarm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;


@Getter
@AllArgsConstructor
public enum AmPmType {
    AM("AM", "오전"),
    PM("PM", "오후");

    private String type;
    private String name;
}
