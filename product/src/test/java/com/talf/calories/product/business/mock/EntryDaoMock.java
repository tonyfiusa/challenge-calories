package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.EntryDao;

import java.util.Arrays;
import java.util.List;

public class EntryDaoMock implements EntryDao {
  @Override
  public List<Entry> getAllEntries() {
    return Arrays.asList(
      new Entry(1, "entry1", 100),
      new Entry(2, "entry2", 200));
  }
}
