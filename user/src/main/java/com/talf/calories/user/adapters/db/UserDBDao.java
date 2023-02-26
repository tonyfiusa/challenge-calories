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
  public Optional<User> getUser(String email) {
    return this.userRepository.findByEmail(email)
      .map(user -> new User(user.id, user.provider, user.email, user.name, user.createdAt));
  }

  @Override
  public User registerUser(String email, String name, String provider) {
    com.talf.calories.user.adapters.db.entities.User user = new com.talf.calories.user.adapters.db.entities.User();
    user.email = email;
    user.name = name;
    user.provider = provider;
    com.talf.calories.user.adapters.db.entities.User saved = this.userRepository.save(user);
    return new User(saved.id, saved.provider, saved.email, saved.name, saved.createdAt);
  }
}
