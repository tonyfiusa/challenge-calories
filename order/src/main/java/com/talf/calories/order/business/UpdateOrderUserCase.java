package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.business.dao.UserDao;
import com.talf.calories.order.business.exceptions.NotPermttedException;
import com.talf.calories.order.entities.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateOrderUserCase {

  private final OrderDao orderDao;
  private final UserDao userDao;

  public UpdateOrderUserCase(OrderDao orderDao, UserDao userDao) {
    this.orderDao = orderDao;
    this.userDao = userDao;
  }

  public Order update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    long currentUserId = this.userDao.getCurrentUserId();
    OrderDao.Order order = this.orderDao.getById(id).orElseThrow(NotPermttedException::new);
    if (order.createdBy() != currentUserId) {
      throw new NotPermttedException();
    }
    Optional<OrderDao.Order> update = this.orderDao.update(id, employeeName, entryId, mainCourseId, beverageId);

    return update.map(updated -> new Order(updated.id(), updated.createdAt(), updated.employeeName(), updated.entryId(), updated.mainCourseId(), updated.beverageId(), updated.totalCalories()))
      .orElseThrow(NotPermttedException::new);
  }
}
