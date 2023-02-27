package com.talf.calories.product.business;

import com.talf.calories.product.business.mock.NotificationDaoMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotifyCaloriesCalculationResultUseCaseTest {

  @Test
  void testNotify_success() {
    List<Long> collector = new ArrayList<>();
    NotifyCaloriesCalculationResultUseCase subject = new NotifyCaloriesCalculationResultUseCase(new NotificationDaoMock(collector));
    subject.notify(1L, 42L);
    assertEquals(1, collector.size());
    assertEquals(42, collector.get(0));
  }
}
