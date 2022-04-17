package com.dev.mm.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "description")
public class DescriptionEntity {

  @Id
  Integer id;

  @Column(name = "description")
  String description;

}
