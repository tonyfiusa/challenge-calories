package com.talf.calories.user.adapters.db.mock;

import com.talf.calories.user.adapters.db.entities.User;
import com.talf.calories.user.adapters.db.repositories.UserRepository;

import java.util.Optional;

public class UserRepositoryMock implements UserRepository {
  @Override
  public Optional<User> findByUsername(String username) {
    User user = new User();
    user.id = 1L;
    user.createdAt = 2;
    user.username = username;
    user.password = "pass";
    return Optional.of(user);
  }

  @Override
  public <S extends User> S save(S entity) {
    return entity;
  }

  @Override
  public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<User> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<User> findAll() {
    return null;
  }

  @Override
  public Iterable<User> findAllById(Iterable<Long> longs) {
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
  public void delete(User entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends User> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
