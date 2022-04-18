package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;

public interface CategoryService {

  CategoryDto getOrCreateCategory(CategoryDto category);

}
