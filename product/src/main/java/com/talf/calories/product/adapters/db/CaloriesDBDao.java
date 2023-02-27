package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.repositories.FoodRepository;
import com.talf.calories.product.business.dao.CaloriesDao;
import org.springframework.stereotype.Service;

@Service
public class CaloriesDBDao implements CaloriesDao {

  private final FoodRepository foodRepository;

  public CaloriesDBDao(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  @Override
  public long getCalories(long foodItem) {
    return foodRepository.findById(foodItem).map(food -> food.calories).orElse(0L);
  }
}
