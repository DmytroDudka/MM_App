package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.entity.CategoryEntity;
import com.dev.mm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;


  @Override
  public CategoryDto getOrCreateCategory(CategoryDto category) {
    CategoryEntity entity = categoryRepository.findById(category.getId()).orElseGet(() -> categoryRepository.save(
        CategoryEntity.builder()
            .category(category.getTextCategory())
            .build()));
    return CategoryDto.builder()
        .id(entity.getId())
        .textCategory(entity.getCategory())
        .build();
  }
}
