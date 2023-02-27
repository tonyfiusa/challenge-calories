package com.talf.calories.order.business;

import com.talf.calories.order.business.mock.NotificationDaoMock;
import com.talf.calories.order.business.mock.OrderDaoMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotifyOrderCaloriesCalculationUseCaseTest {

  @Test
  void testNotify_success() {
    List<List<Long>> collector = new ArrayList<>();
    NotifyOrderCaloriesCalculationUseCase subject = new NotifyOrderCaloriesCalculationUseCase(new NotificationDaoMock(collector), new OrderDaoMock());
    subject.notify(1);
    assertEquals(1, collector.size());
    assertEquals(3, collector.get(0).size());
    assertTrue(collector.get(0).contains(1L));
    assertTrue(collector.get(0).contains(2L));
    assertTrue(collector.get(0).contains(3L));
  }
}
