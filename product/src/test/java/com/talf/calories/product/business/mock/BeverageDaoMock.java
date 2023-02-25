package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.BeverageDao;

import java.util.Arrays;
import java.util.List;

public class BeverageDaoMock implements BeverageDao {
  @Override
  public List<Beverage> getAllBeverages() {
    return Arrays.asList(
      new Beverage(1, "beverage1", 100),
      new Beverage(2, "beverage2", 200));
  }
}
