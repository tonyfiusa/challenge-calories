package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.adapters.controllers.mock.GetAvailableEntriesUseCaseMock;
import com.talf.calories.product.entities.Entry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntryRestControllerTest {

  private final EntryRestController subject = new EntryRestController( new GetAvailableEntriesUseCaseMock());

  @Test
  void getAll() {
    List<Entry> allEntries = subject.getAll();
    assertEquals(2, allEntries.size());
    assertTrue(allEntries.contains(new Entry(1, "entry1")));
    assertTrue(allEntries.contains(new Entry(2, "entry2")));
  }
}
