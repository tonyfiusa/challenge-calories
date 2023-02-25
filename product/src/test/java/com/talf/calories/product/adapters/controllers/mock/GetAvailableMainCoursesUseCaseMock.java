package com.talf.calories.product.adapters.controllers.mock;

import com.talf.calories.product.business.GetAvailableMainCoursesUseCase;
import com.talf.calories.product.entities.MainCourse;

import java.util.Arrays;
import java.util.List;

public class GetAvailableMainCoursesUseCaseMock extends GetAvailableMainCoursesUseCase {
  public GetAvailableMainCoursesUseCaseMock() {
    super(null);
  }

  @Override
  public List<MainCourse> get() {
    return Arrays.asList(new MainCourse(1, "mainCourse1"),
      new MainCourse(2, "mainCourse2"));
  }
}
