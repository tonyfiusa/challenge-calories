package com.talf.calories.user.adapters.controllers.mock;

import com.talf.calories.user.business.GetUserInfoUseCase;
import com.talf.calories.user.business.dao.UserDao;
import com.talf.calories.user.entities.User;

import java.util.Optional;

public class GetUserInfoUseCaseMock extends GetUserInfoUseCase {
  public GetUserInfoUseCaseMock() {
    super(null);
  }

  @Override
  public Optional<User> get(String userEmail) {
    return Optional.of(new User(1, userEmail, "name"));
  }
}
