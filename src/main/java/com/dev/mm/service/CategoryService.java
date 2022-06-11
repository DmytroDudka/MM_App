package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import java.util.List;

public interface CategoryService {

  CategoryDto getOrCreateCategory(String category);

  CategoryDto getCategoryById(Long id);

  List<CategoryDto> getAllCategories();

}
