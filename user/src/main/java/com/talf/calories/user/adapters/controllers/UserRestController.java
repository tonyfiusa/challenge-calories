package com.talf.calories.user.adapters.controllers;

import com.talf.calories.user.business.GetUserInfoUseCase;
import com.talf.calories.user.business.RegisterGoogleUserInfoUseCase;
import com.talf.calories.user.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "user-api")
public class UserRestController {

  private final GetUserInfoUseCase getUserInfoUseCase;
  private final RegisterGoogleUserInfoUseCase registerGoogleUserInfoUseCase;

  public UserRestController(GetUserInfoUseCase getUserInfoUseCase, RegisterGoogleUserInfoUseCase registerGoogleUserInfoUseCase) {
    this.getUserInfoUseCase = getUserInfoUseCase;
    this.registerGoogleUserInfoUseCase = registerGoogleUserInfoUseCase;
  }

  @GetMapping("/")
  @Operation(
    summary = "Returns a user by its email",
    operationId = "get")
  public User get(@RequestParam(name="email") String email) {
    return this.getUserInfoUseCase.get(email).orElse(null);
  }

  @PutMapping("/")
  @Operation(
    summary = "Registers a user for google provider",
    operationId = "register")
  public User register(@RequestParam(name="email") String email,
                       @RequestParam(name="name") String name) {
    return this.registerGoogleUserInfoUseCase.register(email, name);
  }
}
