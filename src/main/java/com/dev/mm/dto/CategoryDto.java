package com.dev.mm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

  Long id;

  String textCategory;

}
