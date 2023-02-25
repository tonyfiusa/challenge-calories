package com.talf.calories.order.business.mock;

import com.talf.calories.order.business.dao.OrderDao;

import java.util.*;

public class OrderDaoMock implements OrderDao {

  private final List<Long> deleteCollector;

  public OrderDaoMock() {
    this.deleteCollector = new ArrayList<>();
  }
  public OrderDaoMock(List<Long> collector) {
    this.deleteCollector = collector;
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
    if (id == 1L) {
      return Optional.of(new Order(1, 1L, 1L, 1L, "name1", 1L, 2L, 3L, 0L));
    }
    if (id == 2L) {
      return Optional.of(new Order(2, 2L, 1L, 1L, "name1", 1L, 2L, 3L, 0L));
    }
    return Optional.empty();
  }

  @Override
  public Order update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return new Order(1, 2L, 1L, 1L, employeeName, entryId, mainCourseId, beverageId, 0L);
  }

  @Override
  public void delete(long id) {
    this.deleteCollector.add(id);
  }
}
