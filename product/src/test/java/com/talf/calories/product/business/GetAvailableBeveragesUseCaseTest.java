package com.talf.calories.product.business;

import com.talf.calories.product.business.mock.BeverageDaoMock;
import com.talf.calories.product.entities.Beverage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAvailableBeveragesUseCaseTest {

  private final GetAvailableBeveragesUseCase subject = new GetAvailableBeveragesUseCase(new BeverageDaoMock());

  @Test
  void get_success() {
    List<Beverage> beverages = subject.get();
    assertEquals(2, beverages.size());
    assertTrue(beverages.contains(new Beverage("id1", "beverage1")));
    assertTrue(beverages.contains(new Beverage("id2", "beverage2")));
  }
}
