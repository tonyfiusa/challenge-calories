package com.talf.calories.user.business.mock;

import com.talf.calories.user.business.dao.UserDao;

import java.util.Optional;

public class UserDaoMock implements UserDao {
  @Override
  public Optional<User> getUser(String email) {
    return Optional.of(new User(1, "username", "password", 0));
  }
}
