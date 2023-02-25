package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.business.dao.UserDao;
import com.talf.calories.order.business.exceptions.NotPermttedException;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrderUserCase {

  private final OrderDao orderDao;
  private final UserDao userDao;

  public DeleteOrderUserCase(OrderDao orderDao, UserDao userDao) {
    this.orderDao = orderDao;
    this.userDao = userDao;
  }

  public void delete(long id) {
    long currentUserId = this.userDao.getCurrentUserId();
    OrderDao.Order order = this.orderDao.getById(id).orElseThrow(NotPermttedException::new);
    if (order.createdBy() != currentUserId) {
      throw new NotPermttedException();
    }
    this.orderDao.delete(id);
  }
}
