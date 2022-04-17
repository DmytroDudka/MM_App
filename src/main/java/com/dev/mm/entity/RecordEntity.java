package com.dev.mm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "record")
public class RecordEntity {

  @Id
  Integer id;

  @Column(name = "name")
  String name;

  @Column(name = "description_id")
  Integer descriptionId;

  @Column(name = "type_id")
  Integer typeId;

  @Column(name = "category_id")
  Integer categoryId;

  @Column(name = "amount")
  Double amount;

}
