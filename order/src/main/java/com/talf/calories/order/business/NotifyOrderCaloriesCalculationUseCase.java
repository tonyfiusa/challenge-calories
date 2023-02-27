package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.NotificationDao;
import com.talf.calories.order.business.dao.OrderDao;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class NotifyOrderCaloriesCalculationUseCase {
  private final NotificationDao notificationDao;
  private final OrderDao orderDao;

  public NotifyOrderCaloriesCalculationUseCase(NotificationDao notificationDao, OrderDao orderDao) {
    this.notificationDao = notificationDao;
    this.orderDao = orderDao;
  }

  public void notify(long orderId) {
    this.orderDao.getById(orderId)
      .ifPresent(order ->
        this.notificationDao.notifyCaloriesCalculation(orderId,
          Stream.of(order.entryId(), order.mainCourseId(), order.beverageId())
            .filter(Objects::nonNull).toList()));
  }
}
