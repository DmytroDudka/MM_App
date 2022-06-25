package com.dev.mm.api;

import com.dev.mm.dto.CategoryStatisticDto;
import com.dev.mm.dto.FlowTypeStatisticDto;
import com.dev.mm.dto.StatisticDto;
import com.dev.mm.service.StatisticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController extends BaseController {

  @Autowired
  StatisticService statisticService;

  @GetMapping
  public StatisticDto getAllStatistic() {
    return statisticService.generateStatisticDto();
  }

  @GetMapping(value = "/category")
  public List<CategoryStatisticDto> getCategoryStatistics() {
    return statisticService.generateCategoryStatisticDto();
  }

  @GetMapping(value = "/flowtype")
  public List<FlowTypeStatisticDto> getFlowTypeStatistics() {
    return statisticService.generateFlowTypeStatisticDto();
  }

}
