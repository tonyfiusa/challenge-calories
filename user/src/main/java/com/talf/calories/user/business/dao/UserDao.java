package com.talf.calories.user.business.dao;

import java.util.Optional;

public interface UserDao {

  Optional<User> getUser(String email);

  User registerUser(String email, String name, String provider);

  record User(long id, String provider, String email, String name, long createdAt) {}
}
