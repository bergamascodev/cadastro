package com.bergamascodev.common;

import java.util.List;
import java.util.Optional;

public interface Converter <Entity, Dto>{

    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    List<Dto> toDtoList(List<Entity> entityList);

    Dto toDtoFromOptionalEntity(Optional<Entity> optionalEntity);

    Optional<Dto> toOptionalDtoFromOptionalEntity(Optional<Entity> entityOptional);
}
