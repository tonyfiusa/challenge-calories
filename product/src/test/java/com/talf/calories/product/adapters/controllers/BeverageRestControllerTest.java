package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.adapters.controllers.mock.GetAvailableBeveragesUseCaseMock;
import com.talf.calories.product.entities.Beverage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BeverageRestControllerTest {

  private final BeverageRestController subject = new BeverageRestController( new GetAvailableBeveragesUseCaseMock());

  @Test
  void getAll() {
    List<Beverage> allBeverages = subject.getAll();
    assertEquals(2, allBeverages.size());
    assertTrue(allBeverages.contains(new Beverage(1, "beverage1")));
    assertTrue(allBeverages.contains(new Beverage(2, "beverage2")));
  }
}
