package com.dev.mm.utils;

import com.dev.mm.dto.CategoryStatisticDto;
import java.util.Comparator;

public class CategoryComparator implements Comparator<CategoryStatisticDto> {

  @Override
  public int compare(CategoryStatisticDto o1, CategoryStatisticDto o2) {
    if (o1 == null || o2 == null) {
      throw new NullPointerException();
    }
    return Double.compare(o1.getSum(), o2.getSum());
  }
}
