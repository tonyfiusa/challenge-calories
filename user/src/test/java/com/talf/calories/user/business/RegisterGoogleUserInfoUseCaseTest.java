package com.talf.calories.user.business;

import com.talf.calories.user.business.mock.UserDaoMock;
import com.talf.calories.user.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterGoogleUserInfoUseCaseTest {

  private final RegisterGoogleUserInfoUseCase subject = new RegisterGoogleUserInfoUseCase(new UserDaoMock());

  @Test
  void register_success() {
    User register = this.subject.register("email", "name");
    assertEquals(new User(1, "email", "name"), register);
  }
}
