package com.talf.calories.user.adapters.db;

import com.talf.calories.user.adapters.db.mock.UserRepositoryMock;
import com.talf.calories.user.business.dao.UserDao;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDBDaoTest {

  private final UserDBDao subject = new UserDBDao(new UserRepositoryMock());

  @Test
  void getUser_success() {
    Optional<UserDao.User> byEmail = subject.getUser("email");
    assertTrue(byEmail.isPresent());
    assertEquals(new UserDao.User(1, "provider", "email", "name", 2), byEmail.get());
  }

  @Test
  void registerUser_success() {
    UserDao.User createdUser = this.subject.registerUser("email", "name", "provider");
    assertEquals(new UserDao.User(1, "provider", "email", "name", 2), createdUser);
  }
}
