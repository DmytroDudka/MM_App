package com.dev.mm.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordDto {

  Long id;

  String name;

  DescriptionDto description;

  CategoryDto category;

  FlowTypeDto flowType;

  Double amount;

}
