package com.talf.calories.product.business;

import com.talf.calories.product.business.mock.EntryDaoMock;
import com.talf.calories.product.entities.Entry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetAvailableEntriesUseCaseTest {

  private final GetAvailableEntriesUseCase subject = new GetAvailableEntriesUseCase(new EntryDaoMock());

  @Test
  void get_success() {
    List<Entry> entries = subject.get();
    assertEquals(2, entries.size());
    assertTrue(entries.contains(new Entry(1, "entry1")));
    assertTrue(entries.contains(new Entry(2, "entry2")));
  }
}
