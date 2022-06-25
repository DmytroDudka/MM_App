package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.CategoryEntity;
import com.dev.mm.entity.FlowTypeEntity;
import com.dev.mm.mapper.FlowTypeMapper;
import com.dev.mm.repository.TypeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  @Autowired
  private TypeRepository typeRepository;

  @Autowired
  FlowTypeMapper flowTypeMapper;

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
  public List<FlowTypeDto> getAllFlowTypes() {

    List<FlowTypeDto> result= new ArrayList<>();
    Iterable<FlowTypeEntity> response = typeRepository.findAll();

    response.forEach(e -> result.add(flowTypeMapper.flowTypeToDto(e)));
    return result;
  }
}
