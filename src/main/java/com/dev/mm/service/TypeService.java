package com.dev.mm.service;

import com.dev.mm.dto.FlowTypeDto;
import java.util.List;

public interface TypeService {

  FlowTypeDto getOrCreateType(String type);

  FlowTypeDto getTypeById(Long id);

  List<FlowTypeDto> getAllFlowTypes();

}
