package com.talf.calories.user.adapters.controllers;

import com.talf.calories.user.adapters.controllers.mock.GetUserInfoUseCaseMock;
import com.talf.calories.user.adapters.controllers.mock.RegisterGoogleUserInfoUseCaseMock;
import com.talf.calories.user.business.GetUserInfoUseCase;
import com.talf.calories.user.business.RegisterGoogleUserInfoUseCase;
import com.talf.calories.user.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRestControllerTest {

  private final UserRestController subject = new UserRestController(
    new GetUserInfoUseCaseMock(),
    new RegisterGoogleUserInfoUseCaseMock()
  );

  @Test
  void get_success() {
    User user = this.subject.get("email1");
    assertEquals(new User(1, "email1", "name"), user);
  }

  @Test
  void register_success() {
    User register = this.subject.register("email1", "name1");
    assertEquals(new User(1, "email1", "name1"), register);
  }
}
