package com.talf.calories.order.business.mock;

import com.talf.calories.order.business.dao.NotificationDao;

import java.util.List;

public class NotificationDaoMock implements NotificationDao {

  private final List<List<Long>> collector;

  public NotificationDaoMock(List<List<Long>> collector) {
    this.collector = collector;
  }

  @Override
  public void notifyCaloriesCalculation(List<Long> itemsIds) {
    this.collector.add(itemsIds);
  }
}
