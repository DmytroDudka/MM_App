package com.dev.mm.api;

import com.dev.mm.dto.CreateRecordDto;
import com.dev.mm.dto.RecordDto;
import com.dev.mm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public RecordDto addRecord(@RequestBody CreateRecordDto createRecordDto){
    return recordService.addRecord(createRecordDto);
  }

  @GetMapping(value = "/{recordId}")
  public RecordDto getRecord(@PathVariable(value = "recordId") Long recordId){
    return recordService.getRecordById(recordId);
  }

  @DeleteMapping(value = "/{recordId}")
  public ResponseEntity deleteRecord(@PathVariable(value = "recordId") Long recordId){
    recordService.deleteRecordById(recordId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
