package com.talf.calories.product.adapters.db.mock;

import com.talf.calories.product.adapters.db.entities.Entry;
import com.talf.calories.product.adapters.db.repositories.EntryRepository;

import java.util.Arrays;
import java.util.Optional;

public class EntryRepositoryMock implements EntryRepository {
  @Override
  public <S extends Entry> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Entry> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Entry> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Entry> findAll() {
    Entry entry1 = new Entry();
    entry1.id = 1L;
    entry1.name = "Salad";
    entry1.calories = 20;
    Entry entry2 = new Entry();
    entry2.id = 2L;
    entry2.name = "Cheese";
    entry2.calories = 150;
    return Arrays.asList(entry1, entry2);
  }

  @Override
  public Iterable<Entry> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(Entry entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Entry> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
