package com.talf.calories.product.adapters.db.entities;

import javax.persistence.*;

@Entity(name = "food")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
  discriminatorType = DiscriminatorType.STRING)
public class Food {
  @Id
  public Long id;
  @Column(name = "name")
  public String name;
  @Column(name = "calories")
  public long calories;
}
