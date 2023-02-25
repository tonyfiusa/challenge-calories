package com.talf.calories.order.adapters.db.repositories;

import com.talf.calories.order.adapters.db.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> findByCreatedBy(long userId);
}
