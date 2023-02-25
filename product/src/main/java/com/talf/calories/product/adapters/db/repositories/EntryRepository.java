package com.talf.calories.product.adapters.db.repositories;

import com.talf.calories.product.adapters.db.entities.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {
}
