package com.talf.calories.product.business.mock;

import com.talf.calories.product.business.dao.MainCourseDao;

import java.util.Arrays;
import java.util.List;

public class MainCourseDaoMock implements MainCourseDao {
  @Override
  public List<MainCourse> getAllMainCourses() {
    return Arrays.asList(
      new MainCourse(1, "mainCourse1", 100),
      new MainCourse(2, "mainCourse2", 200)
    );
  }
}
