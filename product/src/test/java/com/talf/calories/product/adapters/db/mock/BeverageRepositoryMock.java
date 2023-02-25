package com.talf.calories.product.adapters.db.mock;

import com.talf.calories.product.adapters.db.entities.Beverage;
import com.talf.calories.product.adapters.db.repositories.BeverageRepository;

import java.util.Arrays;
import java.util.Optional;

public class BeverageRepositoryMock implements BeverageRepository {
  @Override
  public <S extends Beverage> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Beverage> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Beverage> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Beverage> findAll() {
    Beverage beverage1 = new Beverage();
    beverage1.id = 1L;
    beverage1.name = "Water";
    beverage1.calories = 0;
    Beverage beverage2 = new Beverage();
    beverage2.id = 2L;
    beverage2.name = "Coke";
    beverage2.calories = 200;
    return Arrays.asList(beverage1, beverage2);
  }

  @Override
  public Iterable<Beverage> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(Beverage entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Beverage> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
