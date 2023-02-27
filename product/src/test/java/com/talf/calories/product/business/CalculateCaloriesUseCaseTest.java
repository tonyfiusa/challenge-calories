package com.talf.calories.product.business;

import com.talf.calories.product.business.mock.CaloriesDaoMock;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateCaloriesUseCaseTest {

  private final CalculateCaloriesUseCase subject = new CalculateCaloriesUseCase(new CaloriesDaoMock());

  @Test
  void calculate_success() {
    long calculate = subject.calculate(Arrays.asList(1L, 2L));
    assertEquals(30, calculate);
  }
}
