package com.talf.calories.order.adapters.db.mock;

import com.talf.calories.order.adapters.db.entities.Order;
import com.talf.calories.order.adapters.db.repositories.OrderRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryMock implements OrderRepository {
  @Override
  public List<Order> findByCreatedBy(long userId) {
    Order order1 = new Order();
    order1.id = 1L;
    order1.createdBy = 1;
    order1.createdAt = 1;
    order1.updatedAt = 2;
    order1.employeeName = "name1";
    order1.entryId = 1L;
    order1.mainCourseId = 2L;
    order1.beverageId = 3L;
    order1.totalCalories = 4L;
    return Collections.singletonList(order1);
  }

  @Override
  public <S extends Order> S save(S entity) {
    entity.id = 1L;
    entity.createdBy = 1;
    entity.createdAt = 1;
    entity.updatedAt = 3;
    return entity;
  }

  @Override
  public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Order> findById(Long aLong) {
    if (1 == aLong) {
      Order order1 = new Order();
      order1.id = aLong;
      order1.createdBy = 1;
      order1.createdAt = 1;
      order1.updatedAt = 2;
      order1.employeeName = "name1";
      order1.entryId = 1L;
      order1.mainCourseId = 2L;
      order1.beverageId = 3L;
      order1.totalCalories = 4L;
      return Optional.of(order1);
    }
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Order> findAll() {
    return null;
  }

  @Override
  public Iterable<Order> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {
    if (1L != aLong) {
      throw new IllegalStateException();
    }
  }

  @Override
  public void delete(Order entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Order> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
