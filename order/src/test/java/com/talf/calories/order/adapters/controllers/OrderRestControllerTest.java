package com.talf.calories.order.adapters.controllers;

import com.talf.calories.order.adapters.controllers.mock.DeleteOrderUserCaseMock;
import com.talf.calories.order.adapters.controllers.mock.GetUserOrdersUseCaseMock;
import com.talf.calories.order.adapters.controllers.mock.PlaceOrderUseCaseMock;
import com.talf.calories.order.adapters.controllers.mock.UpdateOrderUserCaseMock;
import com.talf.calories.order.business.DeleteOrderUserCase;
import com.talf.calories.order.business.GetUserOrdersUseCase;
import com.talf.calories.order.business.PlaceOrderUseCase;
import com.talf.calories.order.business.UpdateOrderUserCase;
import com.talf.calories.order.entities.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRestControllerTest {

  private final OrderRestController subject = new OrderRestController(new GetUserOrdersUseCaseMock(),
    new DeleteOrderUserCaseMock(), new UpdateOrderUserCaseMock(), new PlaceOrderUseCaseMock());

  @Test
  void getAll_success() {
    List<Order> all = subject.getAll();
    assertEquals(1, all.size());
    assertEquals(new Order(1, 2, "name", 1L, 2L, 3L, 4L), all.get(0));
  }

  @Test
  void placeOrder_success() {
    Long id = subject.placeOrder("name", 1L, 2L, 3L);
    assertEquals(1, id);
  }

  @Test
  void delete_success() {
    try {
      subject.delete(1);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  void update_success() {
    Order updated = subject.update(1, "newName", 5L, 6L, 7L);
    assertEquals(new Order(1, 2, "newName", 5L, 6L, 7L, 4L), updated);
  }
}
