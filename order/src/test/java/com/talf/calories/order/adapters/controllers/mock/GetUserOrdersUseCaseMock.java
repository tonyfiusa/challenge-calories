package com.talf.calories.order.adapters.controllers.mock;

import com.talf.calories.order.business.GetUserOrdersUseCase;
import com.talf.calories.order.entities.Order;

import java.util.Collections;
import java.util.List;

public class GetUserOrdersUseCaseMock extends GetUserOrdersUseCase {
  public GetUserOrdersUseCaseMock() {
    super(null, null);
  }

  public List<Order> get() {
    return Collections.singletonList(new Order(1, 2, "name", 1L, 2L, 3L, 4L));
  }
}
