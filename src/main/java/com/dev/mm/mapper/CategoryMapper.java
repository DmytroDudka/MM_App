package com.dev.mm.mapper;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  @Mapping(source = "id", target = "id")
  CategoryEntity categoryToEntity(CategoryDto dto);

  @Mapping(source = "id", target = "id")
  CategoryDto categoryToDto(CategoryEntity entity);
}
