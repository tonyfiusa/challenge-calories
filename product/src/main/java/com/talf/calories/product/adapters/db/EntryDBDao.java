package com.talf.calories.product.adapters.db;

import com.talf.calories.product.adapters.db.repositories.EntryRepository;
import com.talf.calories.product.business.dao.EntryDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EntryDBDao implements EntryDao {

  private final EntryRepository entryRepository;

  public EntryDBDao(EntryRepository entryRepository) {
    this.entryRepository = entryRepository;
  }

  @Override
  public List<Entry> getAllEntries() {
    return StreamSupport.stream(this.entryRepository.findAll().spliterator(), false)
      .map(entry -> new Entry(entry.id, entry.name, entry.calories))
      .toList();
  }
}
