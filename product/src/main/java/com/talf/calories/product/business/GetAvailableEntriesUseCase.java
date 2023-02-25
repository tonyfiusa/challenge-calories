package com.talf.calories.product.business;

import com.talf.calories.product.business.dao.EntryDao;
import com.talf.calories.product.entities.Entry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableEntriesUseCase {

  private final EntryDao entryDao;

  public GetAvailableEntriesUseCase(EntryDao entryDao) {
    this.entryDao = entryDao;
  }

  public List<Entry> get() {
    return this.entryDao.getAllEntries().stream().map(entry -> new Entry(entry.id(), entry.name())).toList();
  }
}
