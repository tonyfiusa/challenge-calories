package com.talf.calories.product.business;

import com.talf.calories.product.business.dao.BeverageDao;
import com.talf.calories.product.entities.Beverage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableBeveragesUseCase {

  private final BeverageDao beverageDao;

  public GetAvailableBeveragesUseCase(BeverageDao beverageDao) {
    this.beverageDao = beverageDao;
  }

  public List<Beverage> get() {
    return this.beverageDao.getAllBeverages().stream().map(beverage -> new Beverage(beverage.id(), beverage.name())).toList();
  }
}
