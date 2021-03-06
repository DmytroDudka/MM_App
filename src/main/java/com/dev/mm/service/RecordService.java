package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.CreateRecordDto;
import com.dev.mm.dto.FlowTypeDto;
import com.dev.mm.dto.RecordDto;
import java.util.List;

public interface RecordService {

  RecordDto addRecord(CreateRecordDto createRecordDto);

  RecordDto getRecordById(Long recordId);

  List<RecordDto> getAllRecords();
  void deleteRecordById(Long recordId);

  Double getSumByFlowType(FlowTypeDto flowTypeDto);

  Double getSumByCategory(CategoryDto categoryDto);

}
