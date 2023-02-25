package com.talf.calories.product.business;

import com.talf.calories.product.business.dao.MainCourseDao;
import com.talf.calories.product.entities.MainCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableMainCoursesUseCase {
  private final MainCourseDao mainCourseDao;

  public GetAvailableMainCoursesUseCase(MainCourseDao mainCourseDao) {
    this.mainCourseDao = mainCourseDao;
  }

  public List<MainCourse> get() {
    return this.mainCourseDao.getAllMainCourses().stream().map(entry -> new MainCourse(entry.id(), entry.name())).toList();
  }
}
