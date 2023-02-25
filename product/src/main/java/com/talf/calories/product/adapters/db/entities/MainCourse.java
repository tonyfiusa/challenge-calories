package com.talf.calories.product.adapters.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MainCourse")
public class MainCourse extends Food{
}
