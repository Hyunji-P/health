package com.example.health.entity.converter;

import com.example.health.entity.AmPmType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class AmPmConverter implements AttributeConverter<AmPmType, String> {
    @Override
    public String convertToDatabaseColumn(AmPmType amPm) {
        return amPm != null ? amPm.getType() : null;
    }

    @Override
    public AmPmType convertToEntityAttribute(String type) {
        return type != null ? AmPmType.of(type) : null;
    }
}
