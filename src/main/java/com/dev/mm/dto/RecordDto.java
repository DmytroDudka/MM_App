package com.dev.mm.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordDto {

  Long id;

  String name;

  DescriptionDto description;

  CategoryDto category;

  FlowTypeDto type;

  Double amount;


}
