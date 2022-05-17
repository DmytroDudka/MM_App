package com.dev.mm.service;

import com.dev.mm.dto.TypeDto;
import com.dev.mm.entity.TypeEntity;
import com.dev.mm.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  @Autowired
  private TypeRepository typeRepository;

  @Override
  public TypeDto getOrCreateType(TypeDto type) {

    TypeEntity entity = typeRepository.findById(type.getId()).orElseGet(() -> typeRepository.save(TypeEntity.builder()
        .type(type.getTextType())
        .build()));

    return TypeDto.builder()
        .id(entity.getId())
        .textType(entity.getType())
        .build();
  }
}
