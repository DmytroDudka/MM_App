package com.dev.mm.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "category")
public class CategoryEntity {

  @Id
  Integer id;

  @Column(name = "category")
  String category;

}
