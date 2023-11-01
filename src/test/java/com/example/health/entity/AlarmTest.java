package com.example.health.entity;

import com.example.health.entity.alarm.Alarm;
import com.example.health.entity.alarm.AmPmType;
import com.example.health.entity.alarm.Period;
import com.example.health.entity.alarm.Schedule;
import com.example.health.repository.command.AlarmCommandRepository;
import com.example.health.repository.query.AlarmQueryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class AlarmTest {
    @Autowired
    AlarmQueryRepository alarmQueryRepository;

    @Autowired
    AlarmCommandRepository alarmCommandRepository;
    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void beforeEach() {
        // given
        Schedule morning = new Schedule(AmPmType.AM, 8, 30);
        Schedule lunch = new Schedule(AmPmType.PM, 12, 00);
        Schedule dinner = new Schedule(AmPmType.PM, 20, 20);

        LocalDate startDate = LocalDate.of(2023, 11, 01);
        LocalDate endDate = LocalDate.of(2023, 11, 03);
        Period period = new Period(startDate, endDate);

        Alarm alarm = new Alarm("테스트 알람", period);
        alarm.getSchedules().add(morning);
        alarm.getSchedules().add(lunch);
        alarm.getSchedules().add(dinner);

        // when
        alarmCommandRepository.save(alarm);
    }
    
    @Test
    @DisplayName("알람 전체 조회")
    void 알람_조회_findAll() throws Exception{
        // when
        List<Alarm> result = alarmQueryRepository.findAll();
        Alarm findAlarm = result.get(0);

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(findAlarm.getName()).isEqualTo("테스트 알람");
        assertThat(findAlarm.getPeriod().getStartDate()).isEqualTo(LocalDate.of(2023, 11, 01));
        assertThat(findAlarm.getPeriod().getEndDate()).isEqualTo(LocalDate.of(2023, 11, 03));
        assertThat(findAlarm.getSchedules().size()).isEqualTo(3);
        assertThat(findAlarm.getSchedules()).containsExactly(
                new Schedule(AmPmType.AM, 8, 30),
                new Schedule(AmPmType.PM, 12, 00),
                new Schedule(AmPmType.PM, 20, 20));
    }
    
    @Test
    @DisplayName("알람 단건 조회")
    void 알람_조회_findOne() throws Exception{
        // when
        Alarm findAlarm = alarmQueryRepository.findByName("테스트 알람").get();

        // then
        assertThat(findAlarm.getName()).isEqualTo("테스트 알람");
        assertThat(findAlarm.getPeriod().getStartDate()).isEqualTo(LocalDate.of(2023, 11, 01));
        assertThat(findAlarm.getPeriod().getEndDate()).isEqualTo(LocalDate.of(2023, 11, 03));
        assertThat(findAlarm.getSchedules().size()).isEqualTo(3);
        assertThat(findAlarm.getSchedules()).containsExactly(
                new Schedule(AmPmType.AM, 8, 30),
                new Schedule(AmPmType.PM, 12, 00),
                new Schedule(AmPmType.PM, 20, 20));
    }
    
    
    @Test
    @DisplayName("알람 업데이트")
    void 알람_업데이트() throws Exception{
        // given
        Alarm findAlarm = alarmQueryRepository.findByName("테스트 알람").get();
        findAlarm.changeAlarm("테스트 알람 업데이트", findAlarm.getPeriod(), findAlarm.getSchedules());

        em.flush();
        em.clear();

        // when
        Alarm updatedAlarm = alarmQueryRepository.findByName("테스트 알람 업데이트").get();
        
        // then
        assertThat(updatedAlarm.getName()).isEqualTo("테스트 알람 업데이트");
    }
    
    @Test
    @DisplayName("알람 삭제")
    void AlarmTest() throws Exception{
        // given
        Alarm findAlarm = alarmQueryRepository.findByName("테스트 알람").get();

        // when
        alarmCommandRepository.delete(findAlarm);

        // then
        assertThatThrownBy(() -> {
            Alarm deletedAlarm = alarmQueryRepository.findByName("테스트 알람").get();
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }
    
}