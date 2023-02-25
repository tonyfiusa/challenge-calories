package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.BeverageDao;

import java.util.Arrays;
import java.util.List;

public class BeverageDaoMock implements BeverageDao {
  @Override
  public List<Beverage> getAllBeverages() {
    return Arrays.asList(
      new Beverage("id1", "beverage1", 100),
      new Beverage("id2", "beverage2", 200));
  }
}
