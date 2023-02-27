package com.talf.calories.user.business;

import com.talf.calories.user.business.mock.UserDaoMock;
import com.talf.calories.user.entities.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GetUserInfoUseCaseTest {

  private final GetUserInfoUseCase subject = new GetUserInfoUseCase(new UserDaoMock());

  @Test
  void get_success() {
    Optional<User> user = this.subject.get("username");
    assertTrue(user.isPresent());
    assertEquals(new User(1, "username", "password"), user.get());
  }
}
