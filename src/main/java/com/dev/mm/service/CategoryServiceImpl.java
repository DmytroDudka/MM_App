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
  public CategoryDto getOrCreateCategory(String category) {

    var entity = categoryRepository.getByCategory(category);

    if (entity.isPresent()) {
      return CategoryDto.builder().id(entity.get().getId()).textCategory(category).build();
    }

    var newCategory = categoryRepository.save(CategoryEntity.builder()
        .category(category).build());

    return CategoryDto.builder()
        .id(newCategory.getId())
        .textCategory(category)
        .build();
  }
}
