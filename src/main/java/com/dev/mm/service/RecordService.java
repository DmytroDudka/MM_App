package com.dev.mm.service;

import com.dev.mm.dto.CreateRecordDto;
import com.dev.mm.dto.RecordDto;

public interface RecordService {

  RecordDto addRecord(CreateRecordDto createRecordDto);

  RecordDto getRecordById(Long recordId);

  void deleteRecordById(Long recordId);

}
