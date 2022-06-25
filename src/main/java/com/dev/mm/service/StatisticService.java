package com.dev.mm.service;

import com.dev.mm.dto.CategoryStatisticDto;
import com.dev.mm.dto.FlowTypeStatisticDto;
import com.dev.mm.dto.StatisticDto;
import java.util.List;

public interface StatisticService {

  StatisticDto generateStatisticDto();
  List<CategoryStatisticDto> generateCategoryStatisticDto();
  List<FlowTypeStatisticDto> generateFlowTypeStatisticDto();

}
