package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.CreateRecordDto;
import com.dev.mm.dto.DescriptionDto;
import com.dev.mm.dto.RecordDto;
import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.entity.RecordEntity;
import com.dev.mm.repository.RecordRepository;
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

  @Override
  public RecordDto addRecord(CreateRecordDto createRecordDto) {

    DescriptionDto description = descriptionService.createDescription(createRecordDto.getDescription());

    FlowTypeDto type = typeService.getOrCreateType(createRecordDto.getType());

    CategoryDto category = categoryService.getOrCreateCategory(createRecordDto.getCategory());

    RecordEntity entity = recordRepository.save(RecordEntity.builder()
        .name(createRecordDto.getName())
        .categoryId(category.getId())
        .descriptionId(description.getId())
        .typeId(type.getId())
        .amount(createRecordDto.getAmount())
        .build());

    return RecordDto.builder()
        .id(entity.getId())
        .name(createRecordDto.getName())
        .description(description)
        .category(category)
        .type(type)
        .amount(createRecordDto.getAmount())
        .build();
  }
}
