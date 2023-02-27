package com.talf.calories.product.business.dao;

public interface NotificationDao {
  void notifyCaloriesCalculationResult(long destinationId, long result);
}
