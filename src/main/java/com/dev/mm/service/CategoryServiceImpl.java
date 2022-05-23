package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.entity.CategoryEntity;
import com.dev.mm.repository.CategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;


  @Override
  public CategoryDto getOrCreateCategory(String category) {

    Optional<CategoryEntity> entity = categoryRepository.getByCategory(category);

    if (entity.isPresent()) {
      return CategoryDto.builder().id(entity.get().getId()).categoryName(category).build();
    }

    CategoryEntity newCategory = categoryRepository.save(CategoryEntity.builder()
        .categoryName(category).build());

    return CategoryDto.builder()
        .id(newCategory.getId())
        .categoryName(category)
        .build();
  }

  @Override
  public CategoryDto getCategoryById(Long id) {
    Optional<CategoryEntity> result = categoryRepository.findById(id);
    if (result.isPresent()) {
      CategoryEntity entity = result.get();
      return CategoryDto.builder()
          .id(entity.getId())
          .categoryName(entity.getCategoryName())
          .build();
    }
    throw new RuntimeException();
  }
}
