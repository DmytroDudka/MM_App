package com.dev.mm.mapper;

import com.dev.mm.dto.DescriptionDto;
import com.dev.mm.entity.DescriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DescriptionMapper {

  DescriptionMapper INSTANCE = Mappers.getMapper(DescriptionMapper.class);

  @Mapping(source = "id", target = "id")
  DescriptionEntity descriptionToEntity(DescriptionDto dto);

  @Mapping(source = "id", target = "id")
  DescriptionDto descriptionToDto(DescriptionEntity entity);
}
