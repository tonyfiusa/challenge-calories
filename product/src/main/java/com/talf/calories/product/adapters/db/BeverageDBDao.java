package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.repositories.BeverageRepository;
import com.talf.calories.product.business.dao.BeverageDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BeverageDBDao implements BeverageDao {

  private final BeverageRepository beverageRepository;

  public BeverageDBDao(BeverageRepository beverageRepository) {
    this.beverageRepository = beverageRepository;
  }

  @Override
  public List<Beverage> getAllBeverages() {
    return StreamSupport.stream(this.beverageRepository.findAll().spliterator(), false)
      .map(entry -> new Beverage(entry.id, entry.name, entry.calories))
      .toList();
  }
}
