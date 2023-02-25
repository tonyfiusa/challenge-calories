package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.OrderDao;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderUseCase {

  private final OrderDao orderDao;

  public PlaceOrderUseCase(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  public Long placeOrder(String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return this.orderDao.create(employeeName, entryId, mainCourseId, beverageId);
  }
}
