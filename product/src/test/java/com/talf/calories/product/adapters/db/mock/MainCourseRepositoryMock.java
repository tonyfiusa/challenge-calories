package com.talf.calories.product.adapters.db.mock;

import com.talf.calories.product.adapters.db.entities.MainCourse;
import com.talf.calories.product.adapters.db.repositories.MainCourseRepository;

import java.util.Arrays;
import java.util.Optional;

public class MainCourseRepositoryMock implements MainCourseRepository {
  @Override
  public <S extends MainCourse> S save(S entity) {
    return null;
  }

  @Override
  public <S extends MainCourse> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<MainCourse> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<MainCourse> findAll() {
    MainCourse mainCourse1 = new MainCourse();
    mainCourse1.id = 1L;
    mainCourse1.name = "Fish";
    mainCourse1.calories = 300;
    MainCourse mainCourse2 = new MainCourse();
    mainCourse2.id = 2L;
    mainCourse2.name = "Steak";
    mainCourse2.calories = 1000;
    return Arrays.asList(mainCourse1, mainCourse2);
  }

  @Override
  public Iterable<MainCourse> findAllById(Iterable<Long> longs) {
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
  public void delete(MainCourse entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends MainCourse> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
