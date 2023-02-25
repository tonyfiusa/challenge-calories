package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.business.GetAvailableBeveragesUseCase;
import com.talf.calories.product.entities.Beverage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product/beverage", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "beverage-api")
public class BeverageRestController {

  private final GetAvailableBeveragesUseCase getAvailableBeveragesUseCase;

  public BeverageRestController(GetAvailableBeveragesUseCase getAvailableBeveragesUseCase) {
    this.getAvailableBeveragesUseCase = getAvailableBeveragesUseCase;
  }

  @GetMapping("/")
  @Operation(
    summary = "Returns all available Beverages",
    operationId = "getAll")
  public List<Beverage> getAll() {
    return this.getAvailableBeveragesUseCase.get();
  }
}
