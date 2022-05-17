package com.dev.mm.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DescriptionDto {

  Long id;

  String textDescription;

  Date creationDate;

}
