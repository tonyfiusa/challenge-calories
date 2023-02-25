package com.talf.calories.order.adapters.db;

import com.talf.calories.order.adapters.db.repositories.OrderRepository;
import com.talf.calories.order.business.dao.OrderDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDBDao implements OrderDao {

  private final OrderRepository orderRepository;

  public OrderDBDao(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Long create(String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    com.talf.calories.order.adapters.db.entities.Order order = new com.talf.calories.order.adapters.db.entities.Order();
    order.employeeName = employeeName;
    order.entryId = entryId;
    order.mainCourseId = mainCourseId;
    order.beverageId = beverageId;
    return orderRepository.save(order).id;
  }

  @Override
  public List<Order> getByUserId(long userId) {
    return this.orderRepository.findByCreatedBy(userId).stream()
      .map(this::toDaoOrder)
      .toList();
  }

  @Override
  public Optional<Order> getById(long id) {
    return this.orderRepository.findById(id)
      .map(this::toDaoOrder);
  }

  private Order toDaoOrder(com.talf.calories.order.adapters.db.entities.Order order) {
    return new Order(order.id, order.createdBy, order.createdAt, order.updatedAt, order.employeeName, order.entryId, order.mainCourseId, order.beverageId, order.totalCalories);
  }

  @Override
  public Optional<Order> update(long id, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    return this.orderRepository.findById(id)
      .map(order -> updateOrder(order, employeeName, entryId, mainCourseId, beverageId))
      .map(this.orderRepository::save)
      .map(this::toDaoOrder);
  }

  private com.talf.calories.order.adapters.db.entities.Order updateOrder(com.talf.calories.order.adapters.db.entities.Order order, String employeeName, Long entryId, Long mainCourseId, Long beverageId) {
    order.beverageId = beverageId;
    order.mainCourseId = mainCourseId;
    order.entryId = entryId;
    order.employeeName = employeeName;
    return order;
  }

  @Override
  public void delete(long id) {
    this.orderRepository.deleteById(id);
  }
}
