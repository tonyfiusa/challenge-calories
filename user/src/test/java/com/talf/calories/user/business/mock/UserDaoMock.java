package com.talf.calories.user.business.mock;

import com.talf.calories.user.business.dao.UserDao;

import java.util.Optional;

public class UserDaoMock implements UserDao {
  @Override
  public Optional<User> getUser(String email) {
    return Optional.of(new User(1, "provider", email, "name", 0));
  }

  @Override
  public User registerUser(String email, String name, String provider) {
    return new User(1, provider, email, name, 0);
  }
}
