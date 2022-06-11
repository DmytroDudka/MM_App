package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.entity.CategoryEntity;
import com.dev.mm.mapper.CategoryMapper;
import com.dev.mm.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private CategoryMapper categoryMapper;


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
      return categoryMapper.categoryToDto(result.get());
    }
    throw new RuntimeException();
  }

  @Override
  public List<CategoryDto> getAllCategories() {

    List<CategoryDto> result= new ArrayList<>();
    Iterable<CategoryEntity> response = categoryRepository.findAll();

    response.forEach(e -> result.add(categoryMapper.categoryToDto(e)));
    return result;
  }
}
