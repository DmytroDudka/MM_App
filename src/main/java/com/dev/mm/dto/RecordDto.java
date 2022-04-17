package com.dev.mm.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecordDto {

  Long id;

  String name;

  DescriptionDto description;

  CategoryDto category;

  TypeDto type;

  Double amount;


}
