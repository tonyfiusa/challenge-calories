package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.OrderDao;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderCaloriesUseCase {

  private final OrderDao orderDao;

  public UpdateOrderCaloriesUseCase(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  public void update(long orderId, long totalCalories) {
    this.orderDao.updateCalories(orderId, totalCalories);
  }
}
