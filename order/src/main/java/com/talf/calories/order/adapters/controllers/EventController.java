package com.talf.calories.order.adapters.controllers;

import com.talf.calories.order.business.UpdateOrderCaloriesUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EventController {

  private final UpdateOrderCaloriesUseCase updateOrderCaloriesUseCase;

  public EventController(UpdateOrderCaloriesUseCase updateOrderCaloriesUseCase) {
    this.updateOrderCaloriesUseCase = updateOrderCaloriesUseCase;
  }

  @KafkaListener(topics = "caloriesCalculationResult")
  public void listCaloriesCalculationResult(
    @Payload Long payload,
    @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Long orderId) {
    updateOrderCaloriesUseCase.update(orderId, payload);
  }
}
