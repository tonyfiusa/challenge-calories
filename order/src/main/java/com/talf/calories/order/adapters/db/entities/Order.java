package com.talf.calories.order.adapters.db.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name="order_table")
@EntityListeners(AuditingEntityListener.class)
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public Long id;
  @CreatedBy
  public long createdBy;
  @CreatedDate
  public long createdAt;
  @LastModifiedDate
  public long updatedAt;
  public String employeeName;
  public Long entryId;
  public Long mainCourseId;
  public Long beverageId;
  public Long totalCalories;
}
