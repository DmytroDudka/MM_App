package com.dev.mm.mapper;

import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.FlowTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlowTypeMapper {

  FlowTypeMapper INSTANCE = Mappers.getMapper(FlowTypeMapper.class);

  @Mapping(source = "id", target = "id")
  FlowTypeEntity flowTypeToEntity(FlowTypeDto dto);

  @Mapping(source = "id", target = "id")
  FlowTypeDto flowTypeToDto(FlowTypeEntity entity);

}
