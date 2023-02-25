package com.talf.calories.order.business.exceptions;

public class NotPermttedException extends RuntimeException{
  @Override
  public String getMessage() {
    return "Not permiited";
  }
}
