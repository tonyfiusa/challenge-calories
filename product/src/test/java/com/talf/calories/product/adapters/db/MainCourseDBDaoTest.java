package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.mock.MainCourseRepositoryMock;
import com.talf.calories.product.business.dao.MainCourseDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainCourseDBDaoTest {

  private final MainCourseDBDao subject = new MainCourseDBDao(new MainCourseRepositoryMock());

  @Test
  void getAllMainCourses_success() {
    List<MainCourseDao.MainCourse> allMainCourses = subject.getAllMainCourses();
    assertEquals(2, allMainCourses.size());
    assertTrue(allMainCourses.contains(new MainCourseDao.MainCourse(2, "Steak", 1000)));
    assertTrue(allMainCourses.contains(new MainCourseDao.MainCourse(1, "Fish", 300)));
  }
}
