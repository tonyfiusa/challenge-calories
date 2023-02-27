package com.talf.calories.order.business;

import com.talf.calories.order.business.mock.OrderDaoMock;
import com.talf.calories.order.business.mock.UserDaoMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdateOrderCaloriesUseCaseTest {
  @Test
  void update_success() {
    List<Long> updateCaloriesCollector = new ArrayList<>();
    UpdateOrderCaloriesUseCase subject = new UpdateOrderCaloriesUseCase(new OrderDaoMock(Collections.emptyList(), updateCaloriesCollector));

    subject.update(1, 100);
    assertEquals(1, updateCaloriesCollector.size());
    assertEquals(100, updateCaloriesCollector.get(0));
  }
}
