package com.talf.calories.order.business;

import com.talf.calories.order.business.mock.OrderDaoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderUseCaseTest {

  private final PlaceOrderUseCase subject = new PlaceOrderUseCase(new OrderDaoMock());

  @Test
  void placeOrder_success() {
    Long id = this.subject.placeOrder("name", 1L, 2L, 3L);
    assertEquals(1L, id);
  }
}
