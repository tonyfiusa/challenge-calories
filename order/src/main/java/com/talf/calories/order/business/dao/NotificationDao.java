package com.talf.calories.order.business.dao;

import java.util.List;

public interface NotificationDao {

  void notifyCaloriesCalculation(List<Long> itemsIds);
}
