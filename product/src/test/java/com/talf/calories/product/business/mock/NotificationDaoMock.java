package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.NotificationDao;

import java.util.List;

public class NotificationDaoMock implements NotificationDao {

  private final List<Long> collector;

  public NotificationDaoMock(List<Long> collector) {
    this.collector = collector;
  }

  @Override
  public void notifyCaloriesCalculationResult(long destinationId, long result) {
    this.collector.add(result);
  }
}
