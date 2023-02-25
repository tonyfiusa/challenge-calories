package com.talf.calories.order.business;

import com.talf.calories.order.business.mock.OrderDaoMock;
import com.talf.calories.order.business.mock.UserDaoMock;
import com.talf.calories.order.entities.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetUserOrdersUseCaseTest {

  private final GetUserOrdersUseCase subject = new GetUserOrdersUseCase(new OrderDaoMock(), new UserDaoMock());

  @Test
  void get_success() {
    List<Order> orders = subject.get();
    assertEquals(2, orders.size());
    assertTrue(orders.contains(new Order(1, 1L, "name1", 1L, 2L, 3L, 0L)));
    assertTrue(orders.contains(new Order(2, 2L, "name2", 4L, 5L, 6L, 1000L)));
  }
}
