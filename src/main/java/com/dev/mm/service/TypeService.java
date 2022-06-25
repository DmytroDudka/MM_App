package com.dev.mm.service;

import com.dev.mm.dto.FlowTypeDto;
import java.util.List;

public interface TypeService {

  FlowTypeDto getOrCreateType(String type);

  List<FlowTypeDto> getAllFlowTypes();

}
