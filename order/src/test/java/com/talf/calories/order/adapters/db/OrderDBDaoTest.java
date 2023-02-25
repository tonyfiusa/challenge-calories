package com.talf.calories.order.adapters.db;

import com.talf.calories.order.adapters.db.mock.OrderRepositoryMock;
import com.talf.calories.order.business.dao.OrderDao;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBDaoTest {

  private final OrderDBDao subject = new OrderDBDao(new OrderRepositoryMock());

  @Test
  void create_success() {
    Long id = subject.create("name", 1L, 2L, 3L);
    assertEquals(1, id);
  }

  @Test
  void getByUserId_success() {
    List<OrderDao.Order> byUserId = subject.getByUserId(1);
    assertEquals(1, byUserId.size());
    assertEquals(new OrderDao.Order(1, 1, 1, 2, "name1", 1L, 2L, 3L, 4L), byUserId.get(0));
  }

  @Test
  void getById_success() {
    Optional<OrderDao.Order> byId = subject.getById(1);
    assertTrue(byId.isPresent());
    assertEquals(new OrderDao.Order(1, 1, 1, 2, "name1", 1L, 2L, 3L, 4L), byId.get());
  }

  @Test
  void update_success() {
    Optional<OrderDao.Order> updated = subject.update(1, "newName", 10L, 11L, 12L);
    assertTrue(updated.isPresent());
    assertEquals(new OrderDao.Order(1, 1, 1, 3, "newName", 10L, 11L, 12L, 4L), updated.get());
  }

  @Test
  void update_missing() {
    Optional<OrderDao.Order> updated = subject.update(2, "newName", 10L, 11L, 12L);
    assertTrue(updated.isEmpty());
  }

  @Test
  void delete_success() {
    try {
      this.subject.delete(1);
    } catch (Exception e) {
      fail();
    }
  }
}
