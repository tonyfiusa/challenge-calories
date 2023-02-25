package com.talf.calories.product.adapters.controllers.mock;

import com.talf.calories.product.business.GetAvailableBeveragesUseCase;
import com.talf.calories.product.business.dao.BeverageDao;
import com.talf.calories.product.entities.Beverage;

import java.util.Arrays;
import java.util.List;

public class GetAvailableBeveragesUseCaseMock extends GetAvailableBeveragesUseCase {
  public GetAvailableBeveragesUseCaseMock() {
    super(null);
  }

  @Override
  public List<Beverage> get() {
    return Arrays.asList(new Beverage(1, "beverage1"),
      new Beverage(2, "beverage2"));
  }
}
