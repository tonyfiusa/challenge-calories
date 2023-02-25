package com.talf.calories.order.adapters.controllers.mock;

import com.talf.calories.order.business.DeleteOrderUserCase;
import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.business.dao.UserDao;

public class DeleteOrderUserCaseMock extends DeleteOrderUserCase {
  public DeleteOrderUserCaseMock() {
    super(null, null);
  }

  @Override
  public void delete(long id) {
    if (1 != id) {
      throw new IllegalStateException();
    }
  }
}
