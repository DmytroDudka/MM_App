package com.dev.mm.service;

import com.dev.mm.dto.DescriptionDto;
import com.dev.mm.dto.TypeDto;
import com.dev.mm.entity.DescriptionEntity;
import com.dev.mm.repository.DescriptionRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionServiceImpl implements DescriptionService {

  @Autowired
  DescriptionRepository descriptionRepository;

  @Override
  public DescriptionDto createDescription(DescriptionDto description) {

    DescriptionEntity entity = descriptionRepository.save(DescriptionEntity.builder()
        .description(description.getTextDescription())
        .creationDate(new Date(System.currentTimeMillis()))
        .build());

    return DescriptionDto.builder()
        .id(entity.getId())
        .textDescription(entity.getDescription())
        .creationDate(entity.getCreationDate())
        .build();
  }
}
