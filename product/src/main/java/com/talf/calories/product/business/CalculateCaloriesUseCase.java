package com.talf.calories.product.business;

import com.talf.calories.product.business.dao.CaloriesDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateCaloriesUseCase {

  private final CaloriesDao caloriesDao;

  public CalculateCaloriesUseCase(CaloriesDao caloriesDao) {
    this.caloriesDao = caloriesDao;
  }

  public long calculate(List<Long> foodIds) {
    return foodIds.stream().map(
      this.caloriesDao::getCalories
    ).mapToLong(Long::longValue).sum();
  }
}
