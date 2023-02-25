package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.adapters.controllers.mock.GetAvailableMainCoursesUseCaseMock;
import com.talf.calories.product.entities.MainCourse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainCourseRestControllerTest {

  private final MainCourseRestController subject = new MainCourseRestController( new GetAvailableMainCoursesUseCaseMock());

  @Test
  void getAll() {
    List<MainCourse> allMainCourses = subject.getAll();
    assertEquals(2, allMainCourses.size());
    assertTrue(allMainCourses.contains(new MainCourse(1, "mainCourse1")));
    assertTrue(allMainCourses.contains(new MainCourse(2, "mainCourse2")));
  }
}
