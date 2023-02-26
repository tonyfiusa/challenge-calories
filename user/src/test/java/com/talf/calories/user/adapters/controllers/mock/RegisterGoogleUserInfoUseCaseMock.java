package com.talf.calories.user.adapters.controllers.mock;

import com.talf.calories.user.business.RegisterGoogleUserInfoUseCase;
import com.talf.calories.user.business.dao.UserDao;
import com.talf.calories.user.entities.User;

public class RegisterGoogleUserInfoUseCaseMock extends RegisterGoogleUserInfoUseCase {
  public RegisterGoogleUserInfoUseCaseMock() {
    super(null);
  }

  @Override
  public User register(String email, String name) {
    return new User(1, email, name);
  }
}
