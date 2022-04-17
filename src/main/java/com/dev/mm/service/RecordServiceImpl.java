package com.dev.mm.service;

import com.dev.mm.dto.RecordDto;
import com.dev.mm.entity.CategoryEntity;
import com.dev.mm.entity.DescriptionEntity;
import com.dev.mm.entity.RecordEntity;
import com.dev.mm.entity.TypeEntity;
import com.dev.mm.repository.CategoryRepository;
import com.dev.mm.repository.DescriptionRepository;
import com.dev.mm.repository.RecordRepository;
import com.dev.mm.repository.TypeRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

  @Autowired
  RecordRepository recordRepository;

  @Autowired
  DescriptionRepository descriptionRepository;

  @Autowired
  TypeRepository typeRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public RecordDto addRecord(RecordDto recordDto) {

    DescriptionEntity description = descriptionRepository.save(DescriptionEntity.builder()
        .description(recordDto.getDescription().getTextDescription())
        .creationDate(new Date(System.currentTimeMillis()))
        .build());

    TypeEntity type = typeRepository.findById(recordDto.getType().getId()).orElseGet(() -> typeRepository.save(TypeEntity.builder()
        .type(recordDto.getType().getTextType())
        .build()));

    CategoryEntity category = categoryRepository.findById(recordDto.getCategory().getId()).orElseGet(() -> categoryRepository.save(CategoryEntity.builder()
        .category(recordDto.getCategory().getTextCategory())
        .build()));

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
