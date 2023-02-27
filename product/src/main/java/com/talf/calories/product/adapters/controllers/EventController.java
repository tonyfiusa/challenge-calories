package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.business.CalculateCaloriesUseCase;
import com.talf.calories.product.business.NotifyCaloriesCalculationResultUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EventController {

  private final CalculateCaloriesUseCase calculateCaloriesUseCase;
  private final NotifyCaloriesCalculationResultUseCase notifyCaloriesCalculationResultUseCase;

  public EventController(CalculateCaloriesUseCase calculateCaloriesUseCase, NotifyCaloriesCalculationResultUseCase notifyCaloriesCalculationResultUseCase) {
    this.calculateCaloriesUseCase = calculateCaloriesUseCase;
    this.notifyCaloriesCalculationResultUseCase = notifyCaloriesCalculationResultUseCase;
  }

  @KafkaListener(topics = "caloriesCalculation")
  public void calculate(
    @Payload String payload,
    @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Long orderId) {
    long calculated = calculateCaloriesUseCase.calculate(Arrays.stream(payload.split(",")).map(Long::parseLong).toList());
    notifyCaloriesCalculationResultUseCase.notify(orderId, calculated);
  }
}
