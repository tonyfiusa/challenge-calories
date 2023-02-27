package com.talf.calories.order.business.mock;

import com.talf.calories.order.business.dao.OrderDao;

import java.util.*;

public class OrderDaoMock implements OrderDao {

  private final List<Long> deleteCollector;

  private final List<Long> updateCaloriesCollector;

  public OrderDaoMock() {
    this.deleteCollector = new ArrayList<>();
    this.updateCaloriesCollector = new ArrayList<>();
  }
  public OrderDaoMock(List<Long> collector, List<Long> updateCaloriesCollector) {
    this.deleteCollector = collector;
    this.updateCaloriesCollector = updateCaloriesCollector;
  }

  @Override
  public Long create(String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return 1L;
  }

  @Override
  public List<Order> getByUserId(long userId) {
    if (userId == 1) {
      return Arrays.asList(
        new Order(1, 1L, 1L, 1L, "name1", 1L, 2L, 3L, 0L),
        new Order(2, 1L, 2L, 2L, "name2", 4L, 5L, 6L, 1000L));
    }
    return Collections.emptyList();
  }

  @Override
  public Optional<Order> getById(long id) {
    if (id == 1L || id == 4) {
      return Optional.of(new Order(id, 1L, 1L, 1L, "name1", 1L, 2L, 3L, 0L));
    }
    if (id == 2L) {
      return Optional.of(new Order(2, 2L, 1L, 1L, "name1", 1L, 2L, 3L, 0L));
    }
    return Optional.empty();
  }

  @Override
  public Optional<Order> update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    if (1 == id) {
      return Optional.of(new Order(1, 2L, 1L, 1L, employeeName, entryId, mainCourseId, beverageId, 0L));
    }
    return Optional.empty();
  }

  @Override
  public void delete(long id) {
    this.deleteCollector.add(id);
  }

  @Override
  public Optional<Order> updateCalories(long id, long calories) {
    updateCaloriesCollector.add(calories);
    return Optional.of(new Order(1, 1L, 1L, 1L, "name", 1L, 2L, 3L, calories));
  }
}
