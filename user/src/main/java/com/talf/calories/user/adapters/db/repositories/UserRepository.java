package com.talf.calories.user.adapters.db.repositories;

import com.talf.calories.user.adapters.db.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
