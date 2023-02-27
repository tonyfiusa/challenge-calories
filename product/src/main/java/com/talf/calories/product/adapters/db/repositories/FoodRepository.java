package com.talf.calories.product.adapters.db.repositories;

import com.talf.calories.product.adapters.db.entities.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
}
