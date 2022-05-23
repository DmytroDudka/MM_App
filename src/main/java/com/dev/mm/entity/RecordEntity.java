package com.dev.mm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "record")
public class RecordEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @Column(name = "name")
  String name;

  @JoinColumn(name = "description_id")
  @ManyToOne(fetch = FetchType.EAGER)
  DescriptionEntity description;

  @JoinColumn(name = "type_id")
  @ManyToOne(fetch = FetchType.EAGER)
  FlowTypeEntity flowType;

  @JoinColumn(name = "category_id")
  @ManyToOne(fetch = FetchType.EAGER)
  CategoryEntity category;

  @Column(name = "amount")
  Double amount;

}
