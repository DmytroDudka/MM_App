package com.dev.mm.service;

import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.FlowTypeEntity;
import com.dev.mm.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  @Autowired
  private TypeRepository typeRepository;

  @Override
  public FlowTypeDto getOrCreateType(String type) {

    var entity = typeRepository.getByType(type);

    if (entity.isPresent()) {
      return FlowTypeDto.builder().id(entity.get().getId()).textType(type).build();
    }

    var newFlowType = typeRepository.save(FlowTypeEntity.builder()
        .flowType(type).build());

    return FlowTypeDto.builder()
        .id(newFlowType.getId())
        .textType(type)
        .build();
  }
}
