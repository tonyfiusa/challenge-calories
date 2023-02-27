package com.talf.calories.order.adapters.controllers.mock;

import com.talf.calories.order.business.NotifyOrderCaloriesCalculationUseCase;
import com.talf.calories.order.business.dao.NotificationDao;
import com.talf.calories.order.business.dao.OrderDao;

public class NotifyOrderCaloriesCalculationUseCaseMock extends NotifyOrderCaloriesCalculationUseCase {
  public NotifyOrderCaloriesCalculationUseCaseMock() {
    super(null, null);
  }

  @Override
  public void notify(long orderId) {

  }
}
