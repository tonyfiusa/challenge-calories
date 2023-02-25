package com.talf.calories.order.business.mock;

import com.talf.calories.order.business.dao.UserDao;

public class UserDaoMock implements UserDao {
  @Override
  public long getCurrentUserId() {
    return 1L;
  }
}
