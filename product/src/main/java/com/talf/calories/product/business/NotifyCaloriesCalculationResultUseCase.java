package com.talf.calories.product.business;

import com.talf.calories.product.business.dao.NotificationDao;
import org.springframework.stereotype.Service;

@Service
public class NotifyCaloriesCalculationResultUseCase {

  private final NotificationDao notificationDao;

  public NotifyCaloriesCalculationResultUseCase(NotificationDao notificationDao) {
    this.notificationDao = notificationDao;
  }

  public void notify(long destinationId, long result) {
    this.notificationDao.notifyCaloriesCalculationResult(destinationId, result);
  }
}
