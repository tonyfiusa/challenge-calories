package com.talf.calories.product.business;

import com.talf.calories.product.business.mock.MainCourseDaoMock;
import com.talf.calories.product.entities.MainCourse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAvailableMainCoursesUseCaseTest {

  private final GetAvailableMainCoursesUseCase subject = new GetAvailableMainCoursesUseCase(new MainCourseDaoMock());

  @Test
  void get_success() {
    List<MainCourse> mainCourses = subject.get();
    assertEquals(2, mainCourses.size());
    assertTrue(mainCourses.contains(new MainCourse(1, "mainCourse1")));
    assertTrue(mainCourses.contains(new MainCourse(2, "mainCourse2")));
  }
}
