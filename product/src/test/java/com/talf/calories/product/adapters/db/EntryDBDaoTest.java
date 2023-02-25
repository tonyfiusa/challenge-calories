package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.mock.EntryRepositoryMock;
import com.talf.calories.product.business.dao.EntryDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntryDBDaoTest {

  private final EntryDBDao subject = new EntryDBDao(new EntryRepositoryMock());

  @Test
  void getAllEntries_success() {
    List<EntryDao.Entry> allEntries = subject.getAllEntries();
    assertEquals(2, allEntries.size());
    assertTrue(allEntries.contains(new EntryDao.Entry(1, "Salad", 20)));
    assertTrue(allEntries.contains(new EntryDao.Entry(2, "Cheese", 150)));
  }
}
