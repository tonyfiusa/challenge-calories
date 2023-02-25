package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.business.GetAvailableMainCoursesUseCase;
import com.talf.calories.product.entities.MainCourse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product/main-course", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "main-course-api")
public class MainCourseRestController {

  private final GetAvailableMainCoursesUseCase getAvailableMainCoursesUseCase;

  public MainCourseRestController(GetAvailableMainCoursesUseCase getAvailableMainCoursesUseCase) {
    this.getAvailableMainCoursesUseCase = getAvailableMainCoursesUseCase;
  }

  @GetMapping("/")
  @Operation(
    summary = "Returns all available Main Courses",
    operationId = "getAll")
  public List<MainCourse> getAll() {
    return this.getAvailableMainCoursesUseCase.get();
  }
}
