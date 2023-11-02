package com.example.health.domain.alarm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlarmDto {
    private Long id;
    private String name;
}
