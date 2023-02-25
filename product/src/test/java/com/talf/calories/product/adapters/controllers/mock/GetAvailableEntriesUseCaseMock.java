package com.talf.calories.product.adapters.controllers.mock;

import com.talf.calories.product.business.GetAvailableEntriesUseCase;
import com.talf.calories.product.entities.Entry;

import java.util.Arrays;
import java.util.List;

public class GetAvailableEntriesUseCaseMock extends GetAvailableEntriesUseCase {
  public GetAvailableEntriesUseCaseMock() {
    super(null);
  }

  @Override
  public List<Entry> get() {
    return Arrays.asList(new Entry(1, "entry1"),
      new Entry(2, "entry2"));
  }
}
