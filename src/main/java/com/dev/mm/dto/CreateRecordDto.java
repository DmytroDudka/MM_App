package com.dev.mm.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRecordDto {

  String name;

  String description;

  String category;

  String type;

  Double amount;

}