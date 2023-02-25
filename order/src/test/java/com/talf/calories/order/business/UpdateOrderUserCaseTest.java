package com.talf.calories.order.business;

import com.talf.calories.order.business.exceptions.NotPermttedException;
import com.talf.calories.order.business.mock.OrderDaoMock;
import com.talf.calories.order.business.mock.UserDaoMock;
import com.talf.calories.order.entities.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UpdateOrderUserCaseTest {

  private final UpdateOrderUserCase subject = new UpdateOrderUserCase(new OrderDaoMock(), new UserDaoMock());

  @Test
  void update_success() {
    Order updated = subject.update(1, "newName", 10L, 11L, 12L);
    assertEquals(new Order(1, 1L, "newName", 10L, 11L, 12L, 0L), updated);
  }

  @Test
  void update_missing() {
    try {
      subject.update(3, "newName", 10L, 11L, 12L);
    } catch (NotPermttedException npe) {
      return;
    }
    fail();
  }

  @Test
  void update_result_missing() {
    try {
      subject.update(4, "newName", 10L, 11L, 12L);
    } catch (NotPermttedException npe) {
      return;
    }
    fail();
  }

  @Test
  void update_notAllowed() {
    try {
      subject.update(2, "newName", 10L, 11L, 12L);
    } catch (NotPermttedException npe) {
      return;
    }
    fail();
  }
}
