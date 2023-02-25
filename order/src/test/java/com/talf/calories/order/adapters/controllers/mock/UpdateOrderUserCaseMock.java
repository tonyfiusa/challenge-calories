package com.talf.calories.order.adapters.controllers.mock;

import com.talf.calories.order.business.UpdateOrderUserCase;
import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.business.dao.UserDao;
import com.talf.calories.order.entities.Order;

public class UpdateOrderUserCaseMock extends UpdateOrderUserCase {
  public UpdateOrderUserCaseMock() {
    super(null, null);
  }

  @Override
  public Order update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return new Order(1, 2, employeeName, entryId, mainCourseId, beverageId, 4L);
  }
}
