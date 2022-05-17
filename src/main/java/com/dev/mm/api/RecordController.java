package com.dev.mm.api;

import com.dev.mm.dto.RecordDto;
import com.dev.mm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {

  @Autowired
  private RecordService recordService;

  @PostMapping(value = "/add")
  public RecordDto addRecord(@RequestBody RecordDto recordDto){
    return recordService.addRecord(recordDto);
  }

}
