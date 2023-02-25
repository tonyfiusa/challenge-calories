package com.talf.calories.product.business.dao;

import java.util.List;

public interface EntryDao {
  List<Entry> getAllEntries();

  record Entry(long id, String name, long calories) {}
}
