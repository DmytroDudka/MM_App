package com.dev.mm.service;

import com.dev.mm.dto.FlowTypeDto;

public interface TypeService {

  FlowTypeDto getOrCreateType(String type);

}
