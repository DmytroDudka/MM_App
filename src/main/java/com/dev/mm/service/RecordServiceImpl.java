package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.CreateRecordDto;
import com.dev.mm.dto.DescriptionDto;
import com.dev.mm.dto.RecordDto;
import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.RecordEntity;
import com.dev.mm.mapper.CategoryMapper;
import com.dev.mm.mapper.DescriptionMapper;
import com.dev.mm.mapper.FlowTypeMapper;
import com.dev.mm.mapper.RecordMapper;
import com.dev.mm.repository.RecordRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

  @Autowired
  private RecordRepository recordRepository;
  @Autowired
  private DescriptionService descriptionService;
  @Autowired
  private TypeService typeService;
  @Autowired
  private CategoryService categoryService;

  @Autowired
  private RecordMapper recordMapper;
  @Autowired
  private CategoryMapper categoryMapper;
  @Autowired
  private FlowTypeMapper flowTypeMapper;
  @Autowired
  private DescriptionMapper descriptionMapper;

  @Override
  public RecordDto addRecord(CreateRecordDto createRecordDto) {

    DescriptionDto description = descriptionService.createDescription(
        createRecordDto.getDescription());

    FlowTypeDto type = typeService.getOrCreateType(createRecordDto.getType());

    CategoryDto category = categoryService.getOrCreateCategory(createRecordDto.getCategory());

    RecordEntity entity = recordRepository.save(RecordEntity.builder()
        .name(createRecordDto.getName())
        .category(categoryMapper.categoryToEntity(category))
        .description(descriptionMapper.descriptionToEntity(description))
        .flowType(flowTypeMapper.flowTypeToEntity(type))
        .amount(createRecordDto.getAmount())
        .build());

    return recordMapper.recordToDto(entity);
  }

  @Override
  public RecordDto updateRecord(CreateRecordDto createRecordDto) {
    //TODO: Implement update functionality
    return null;
  }

  @Override
  public RecordDto getRecordById(Long recordId) {
    Optional<RecordEntity> result = recordRepository.findById(recordId);
    if (result.isPresent()) {
      RecordEntity record = result.get();
      return recordMapper.recordToDto(record);
    }
    return null;
  }

  @Override
  public List<RecordDto> getAllRecords() {
    List<RecordEntity> recordEntities = recordRepository.findAll();
    List<RecordDto> recordDtos = new ArrayList<>();

    for (RecordEntity recordEntity : recordEntities) {
      recordDtos.add(recordMapper.recordToDto(recordEntity));
    }

    return recordDtos;
  }

  @Override
  public void deleteRecordById(Long recordId) {
    recordRepository.deleteById(recordId);
  }

  @Override
  public Double getSumByFlowType(FlowTypeDto flowTypeDto) {
    Optional<Double> result = recordRepository.getSumByFlowType(flowTypeDto.getId());
    return result.orElseGet(() -> (double) 0);
  }

  @Override
  public Double getSumByCategory(CategoryDto categoryDto) {
    Optional<Double> result = recordRepository.getSumByCategory(categoryDto.getId());
    return result.orElseGet(() -> (double) 0);
  }
}
