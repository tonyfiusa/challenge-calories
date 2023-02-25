package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.mock.BeverageRepositoryMock;
import com.talf.calories.product.business.dao.BeverageDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeverageDBDaoTest {

  private final BeverageDBDao subject = new BeverageDBDao(new BeverageRepositoryMock());

  @Test
  void getAllBeverages_success() {
    List<BeverageDao.Beverage> allBeverages = subject.getAllBeverages();
    assertEquals(2, allBeverages.size());
    assertTrue(allBeverages.contains(new BeverageDao.Beverage(2, "Coke", 200)));
    assertTrue(allBeverages.contains(new BeverageDao.Beverage(1, "Water", 0)));
  }
}
