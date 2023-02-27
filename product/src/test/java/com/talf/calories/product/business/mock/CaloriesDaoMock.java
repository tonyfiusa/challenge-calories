package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.CaloriesDao;

public class CaloriesDaoMock implements CaloriesDao {

  @Override
  public long getCalories(long foodItem) {
    if (1L == foodItem) {
      return 10;
    }
    if (2L == foodItem) {
      return 20;
    }
    return 0;
  }
}
