package com.example.health.domain.alarm.repository.query;

import com.example.health.domain.alarm.domain.QAlarm;
import com.example.health.domain.alarm.dto.AlarmDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.health.domain.alarm.domain.QAlarm.alarm;
import static com.querydsl.core.types.Projections.constructor;

public class AlarmQueryRepositoryImpl implements AlarmQueryRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public AlarmQueryRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<AlarmDto> findAllAlarm() {
        return queryFactory.select(
                        constructor(AlarmDto.class,
                                alarm.id,
                                alarm.name)
                ).from(alarm)
                .fetch();
    }
}
