package com.dev.mm.service;

import com.dev.mm.dto.RecordDto;
import org.springframework.stereotype.Service;

public interface RecordService {

  RecordDto addRecord(RecordDto recordDto);
}
