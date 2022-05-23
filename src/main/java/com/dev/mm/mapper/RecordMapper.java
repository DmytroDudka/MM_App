package com.dev.mm.mapper;

import com.dev.mm.dto.RecordDto;
import com.dev.mm.entity.RecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecordMapper {

  RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);

  @Mapping(source = "id", target = "id")
  RecordEntity recordToEntity(RecordDto dto);


  @Mapping(source = "id", target = "id")
  RecordDto recordToDto(RecordEntity entity);
}
