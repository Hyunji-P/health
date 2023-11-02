package com.example.health.entity.recode.body;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QInbodyEntity is a Querydsl query type for InbodyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInbodyEntity extends EntityPathBase<BodyEntity> {

    private static final long serialVersionUID = 227197901L;

    public static final QInbodyEntity inbodyEntity = new QInbodyEntity("inbodyEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QInbodyEntity(String variable) {
        super(BodyEntity.class, forVariable(variable));
    }

    public QInbodyEntity(Path<? extends BodyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInbodyEntity(PathMetadata metadata) {
        super(BodyEntity.class, metadata);
    }

}

