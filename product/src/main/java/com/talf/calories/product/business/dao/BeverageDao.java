package com.talf.calories.product.business.dao;

import java.util.List;

public interface BeverageDao {
  List<Beverage> getAllBeverages();

  record Beverage(String id, String name, long calories) {}
}
