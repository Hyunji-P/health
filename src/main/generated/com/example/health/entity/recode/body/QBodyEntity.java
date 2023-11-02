package com.example.health.entity.recode.body;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBodyEntity is a Querydsl query type for BodyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBodyEntity extends EntityPathBase<BodyEntity> {

    private static final long serialVersionUID = 615364717L;

    public static final QBodyEntity bodyEntity = new QBodyEntity("bodyEntity");

    public final NumberPath<Float> fatMass = createNumber("fatMass", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> measurementDate = createDateTime("measurementDate", java.time.LocalDateTime.class);

    public final NumberPath<Float> muscleMass = createNumber("muscleMass", Float.class);

    public final NumberPath<Float> weight = createNumber("weight", Float.class);

    public QBodyEntity(String variable) {
        super(BodyEntity.class, forVariable(variable));
    }

    public QBodyEntity(Path<? extends BodyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBodyEntity(PathMetadata metadata) {
        super(BodyEntity.class, metadata);
    }

}

