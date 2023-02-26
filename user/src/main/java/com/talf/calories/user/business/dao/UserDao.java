package com.talf.calories.user.business.dao;

import java.util.Optional;

public interface UserDao {

  Optional<User> getUser(String email);

  record User(long id, String username, String password, long createdAt) {}
}
