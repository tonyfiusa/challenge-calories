package com.talf.calories.user.business;

import com.talf.calories.user.business.dao.UserDao;
import com.talf.calories.user.entities.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterGoogleUserInfoUseCase {

  private final UserDao userDao;

  public RegisterGoogleUserInfoUseCase(UserDao userDao) {
    this.userDao = userDao;
  }

  public User register(String email, String name) {
    UserDao.User userCreated = this.userDao.registerUser(email, name, "google");
    return new User(userCreated.id(), userCreated.email(), userCreated.name());
  }
}
