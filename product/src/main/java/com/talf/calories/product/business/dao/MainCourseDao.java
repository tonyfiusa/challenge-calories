package com.talf.calories.product.business.dao;

import java.util.List;

public interface MainCourseDao {
  List<MainCourse> getAllMainCourses();

  record MainCourse(String id, String name, long calories) {}
}
