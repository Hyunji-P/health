package com.example.health.domain.recode.body;

import com.example.health.global.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BodyEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Float weight;

    private Float muscleMass;

    private Float fatMass;

    private LocalDateTime measurementDate;
}
