package com.talf.calories.order.business.dao;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
  Long create(String employeeName, Long entryId, Long mainCourseId, Long beverageId);
  List<Order> getByUserId(long userId);

  Optional<Order> getById(long id);
  Order update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId);
  void delete(long id);

  record Order(long id, long createdBy, long createdAt, long updatedAt, String employeeName, Long entryId, Long mainCourseId, Long beverageId, Long totalCalories) {}
}
