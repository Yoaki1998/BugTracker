package com.yoaki.BugTracker.mappers;

public interface Mapper<DTO ,Entity> {

    Entity mapTo(DTO dto);

    DTO mapFrom(Entity entity);

}
