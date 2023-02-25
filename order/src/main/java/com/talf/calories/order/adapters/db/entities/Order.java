package com.talf.calories.order.adapters.db.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="order")
public class Order {
  @Id
  public long id;
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
