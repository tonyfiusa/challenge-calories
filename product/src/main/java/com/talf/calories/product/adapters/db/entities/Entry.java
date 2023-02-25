package com.talf.calories.product.adapters.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entry")
public class Entry extends Food{
}
