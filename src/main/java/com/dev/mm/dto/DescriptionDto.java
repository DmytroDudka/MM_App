package com.dev.mm.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DescriptionDto {

  Long id;

  String textDescription;

  Date creationDate;

}
