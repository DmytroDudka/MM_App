package com.dev.mm.utils;

import com.dev.mm.dto.FlowTypeStatisticDto;
import java.util.Comparator;

public class FlowTypeComparator implements Comparator<FlowTypeStatisticDto> {

  @Override
  public int compare(FlowTypeStatisticDto o1, FlowTypeStatisticDto o2) {
    if (o1 == null || o2 == null) {
      throw new NullPointerException();
    }
    return Double.compare(o1.getSum(), o2.getSum());
  }

}
