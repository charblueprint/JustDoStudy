package com.eoe.jds.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QToDo is a Querydsl query type for ToDo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QToDo extends EntityPathBase<ToDo> {

    private static final long serialVersionUID = -67382052L;

    public static final QToDo toDo = new QToDo("toDo");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final BooleanPath done = createBoolean("done");

    public final StringPath id = createString("id");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final StringPath userId = createString("userId");

    public QToDo(String variable) {
        super(ToDo.class, forVariable(variable));
    }

    public QToDo(Path<? extends ToDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QToDo(PathMetadata metadata) {
        super(ToDo.class, metadata);
    }

}

