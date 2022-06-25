package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.CategoryStatisticDto;
import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.dto.FlowTypeStatisticDto;
import com.dev.mm.dto.StatisticDto;
import com.dev.mm.utils.CategoryComparator;
import com.dev.mm.utils.FlowTypeComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

  @Autowired
  CategoryService categoryService;

  @Autowired
  TypeService typeService;

  @Autowired
  RecordService recordService;

  @Override
  public StatisticDto generateStatisticDto() {
    List<CategoryStatisticDto> sortedCategory = getCategoryStatistics();

    List<FlowTypeStatisticDto> sortedType = getTypeStatistics();

    return StatisticDto.builder()
        .categoryStatistics(sortedCategory)
        .flowTypeStatistics(sortedType)
        .build();
  }

  @Override
  public List<CategoryStatisticDto> generateCategoryStatisticDto() {
    return getCategoryStatistics();
  }

  @Override
  public List<FlowTypeStatisticDto> generateFlowTypeStatisticDto() {
    return getTypeStatistics();
  }


  private List<CategoryStatisticDto> getCategoryStatistics() {
    List<CategoryDto> dtos = categoryService.getAllCategories();
    List<CategoryStatisticDto> statisticDtos = new ArrayList<>();
    dtos.stream().map(e -> statisticDtos.add(CategoryStatisticDto.builder()
        .category(e.getCategoryName())
        .sum(recordService.getSumByCategory(e))
        .build())).collect(Collectors.toList());

    statisticDtos.sort(new CategoryComparator());
    return statisticDtos;
  }

  private List<FlowTypeStatisticDto> getTypeStatistics() {
    List<FlowTypeDto> dtos = typeService.getAllFlowTypes();
    List<FlowTypeStatisticDto> statisticDtos = new ArrayList<>();
    dtos.stream().map(e -> statisticDtos.add(FlowTypeStatisticDto.builder()
        .flowType(e.getFlowType())
        .sum(recordService.getSumByFlowType(e))
        .build())).collect(Collectors.toList());
    statisticDtos.sort(new FlowTypeComparator());

    return statisticDtos;
  }
}
