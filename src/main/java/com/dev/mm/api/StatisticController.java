package com.dev.mm.api;

import com.dev.mm.dto.StatisticDto;
import com.dev.mm.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

  @Autowired
  StatisticService statisticService;

  @GetMapping
  public StatisticDto getAllRecords() {
    return statisticService.generateStatisticDto();
  }

}
