package com.dev.mm.service;

import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.FlowTypeEntity;
import com.dev.mm.repository.TypeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  @Autowired
  private TypeRepository typeRepository;

  @Override
  public FlowTypeDto getOrCreateType(String type) {

    Optional<FlowTypeEntity> entity = typeRepository.getByType(type);

    if (entity.isPresent()) {
      return FlowTypeDto.builder().id(entity.get().getId()).flowType(type).build();
    }

    FlowTypeEntity newFlowType = typeRepository.save(FlowTypeEntity.builder()
        .flowType(type).build());

    return FlowTypeDto.builder()
        .id(newFlowType.getId())
        .flowType(type)
        .build();
  }

  @Override
  public FlowTypeDto getTypeById(Long id) {
    Optional<FlowTypeEntity> result = typeRepository.findById(id);
    if (result.isPresent()) {
      FlowTypeEntity entity = result.get();
      return FlowTypeDto.builder()
          .id(entity.getId())
          .flowType(entity.getFlowType())
          .build();
    }
    throw new RuntimeException();
  }
}
