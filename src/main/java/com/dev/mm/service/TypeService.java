package com.dev.mm.service;

import com.dev.mm.dto.CategoryDto;
import com.dev.mm.dto.TypeDto;

public interface TypeService {

  TypeDto getOrCreateType(TypeDto type);

}
