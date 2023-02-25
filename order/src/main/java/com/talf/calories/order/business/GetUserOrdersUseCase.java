package com.talf.calories.order.business;

import com.talf.calories.order.business.dao.OrderDao;
import com.talf.calories.order.business.dao.UserDao;
import com.talf.calories.order.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserOrdersUseCase {

  private final OrderDao orderDao;
  private final UserDao userDao;

  public GetUserOrdersUseCase(OrderDao orderDao, UserDao userDao) {
    this.orderDao = orderDao;
    this.userDao = userDao;
  }

  public List<Order> get() {
    return this.orderDao.getByUserId(this.userDao.getCurrentUserId()).stream()
      .map(order -> new Order(order.id(), order.createdAt(), order.employeeName(), order.entryId(), order.mainCourseId(), order.beverageId(), order.totalCalories()))
      .toList();
  }
}
