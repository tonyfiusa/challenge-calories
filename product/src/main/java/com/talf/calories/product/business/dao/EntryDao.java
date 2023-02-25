package com.talf.calories.product.business.dao;

import java.util.List;

public interface EntryDao {
  List<Entry> getAllEntries();

  record Entry(String id, String name, long calories) {}
}
