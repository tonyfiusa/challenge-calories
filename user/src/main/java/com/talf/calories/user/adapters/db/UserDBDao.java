package com.talf.calories.user.adapters.db;

import com.talf.calories.user.adapters.db.repositories.UserRepository;
import com.talf.calories.user.business.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDBDao implements UserDao {

  private final UserRepository userRepository;

  public UserDBDao(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> getUser(String username) {
    return this.userRepository.findByUsername(username)
      .map(user -> new User(user.id, user.username, user.password, user.createdAt));
  }
}
