package com.talf.calories.order.adapters.controllers.mock;

import com.talf.calories.order.business.PlaceOrderUseCase;
import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.entities.Order;

public class PlaceOrderUseCaseMock extends PlaceOrderUseCase {
  public PlaceOrderUseCaseMock() {
    super(null);
  }

  @Override
  public Long placeOrder(String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return 1L;
  }
}
