package com.example.health.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSchedule extends BeanPath<Schedule> {

    private static final long serialVersionUID = 1051289569L;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final EnumPath<AmPmType> amPm = createEnum("amPm", AmPmType.class);

    public final NumberPath<Integer> hours = createNumber("hours", Integer.class);

    public final NumberPath<Integer> minutes = createNumber("minutes", Integer.class);

    public QSchedule(String variable) {
        super(Schedule.class, forVariable(variable));
    }

    public QSchedule(Path<? extends Schedule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchedule(PathMetadata metadata) {
        super(Schedule.class, metadata);
    }

}

