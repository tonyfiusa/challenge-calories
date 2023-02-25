package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.repositories.MainCourseRepository;
import com.talf.calories.product.business.dao.MainCourseDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class MainCourseDBDao implements MainCourseDao {

  private final MainCourseRepository mainCourseRepository;

  public MainCourseDBDao(MainCourseRepository mainCourseRepository) {
    this.mainCourseRepository = mainCourseRepository;
  }

  @Override
  public List<MainCourse> getAllMainCourses() {
    return StreamSupport.stream(this.mainCourseRepository.findAll().spliterator(), false)
      .map(mainCourse -> new MainCourse(mainCourse.id, mainCourse.name, mainCourse.calories))
      .toList();
  }
}
