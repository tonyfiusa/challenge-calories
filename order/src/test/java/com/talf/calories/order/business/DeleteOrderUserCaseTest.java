package com.talf.calories.order.business;

import com.talf.calories.order.business.exceptions.NotPermttedException;
import com.talf.calories.order.business.mock.OrderDaoMock;
import com.talf.calories.order.business.mock.UserDaoMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteOrderUserCaseTest {

  @Test
  void delete_success() {
    List<Long> deleteCollector = new ArrayList<>();
    DeleteOrderUserCase subject = new DeleteOrderUserCase(new OrderDaoMock(deleteCollector), new UserDaoMock());
    subject.delete(1);
    assertEquals(1, deleteCollector.size());
    assertEquals(1, deleteCollector.get(0));
  }

  @Test
  void delete_missing() {
    List<Long> deleteCollector = new ArrayList<>();
    DeleteOrderUserCase subject = new DeleteOrderUserCase(new OrderDaoMock(deleteCollector), new UserDaoMock());
    try {
      subject.delete(3);
    } catch (NotPermttedException npe) {
      assertTrue(deleteCollector.isEmpty());
      return;
    }
    fail();
  }

  @Test
  void delete_notAllowed() {
    List<Long> deleteCollector = new ArrayList<>();
    DeleteOrderUserCase subject = new DeleteOrderUserCase(new OrderDaoMock(deleteCollector), new UserDaoMock());
    try {
      subject.delete(2);
    } catch (NotPermttedException npe) {
      assertTrue(deleteCollector.isEmpty());
      return;
    }
    fail();
  }

}
