package com.talf.calories.user.business;

import com.talf.calories.user.business.dao.UserDao;
import com.talf.calories.user.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserInfoUseCase {

  private final UserDao userDao;

  public GetUserInfoUseCase(UserDao userDao) {
    this.userDao = userDao;
  }

  public Optional<User> get(String userEmail) {
    return this.userDao.getUser(userEmail)
      .map(user -> new User(user.id(), user.username(), user.password()));
  }
}
