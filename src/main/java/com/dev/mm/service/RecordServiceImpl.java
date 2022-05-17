package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.DescriptionDto;
import com.dev.mm.dto.RecordDto;
import com.dev.mm.dto.TypeDto;
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
  public RecordDto addRecord(RecordDto recordDto) {

    DescriptionDto description = descriptionService.createDescription(recordDto.getDescription());

    TypeDto type = typeService.getOrCreateType(recordDto.getType());

    CategoryDto category = categoryService.getOrCreateCategory(recordDto.getCategory());

    recordRepository.save(RecordEntity.builder()
        .name(recordDto.getName())
        .categoryId(category.getId())
        .descriptionId(description.getId())
        .typeId(type.getId())
        .amount(recordDto.getAmount())
        .build());

    return recordDto;
  }
}
