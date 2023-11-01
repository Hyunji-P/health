package com.example.health.entity;

import com.example.health.exception.EnumNotFoundException;
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

    public static AmPmType of(String type){
        return Stream.of(AmPmType.values())
                .filter(v -> v.getType().equals(type))
                .findAny()
                .orElseThrow(() -> new EnumNotFoundException(String.format("파라미터 %s에 해당하는 데이터가 존재하지 않습니다. 파라미터는 AM, PM 둘 중 하나만 사용 가능합니다.", type)));
    }
}
