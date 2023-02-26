package com.talf.calories.user.adapters.db.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public Long id;
  @CreatedDate
  public long createdAt;
  public String username;
  public String password;
}
