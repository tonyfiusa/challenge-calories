package com.talf.calories.product.adapters.db.repositories;

import com.talf.calories.product.adapters.db.entities.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface BeverageRepository extends CrudRepository<Beverage, Long> {
}
