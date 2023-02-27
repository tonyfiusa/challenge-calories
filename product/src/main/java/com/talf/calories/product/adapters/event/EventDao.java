package com.talf.calories.product.adapters.event;

import com.talf.calories.product.business.dao.NotificationDao;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventDao implements NotificationDao {

  private final KafkaTemplate<Long, Long> kafkaTemplate;

  public EventDao(KafkaTemplate<Long, Long> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void notifyCaloriesCalculationResult(long destinationId, long result) {
    this.kafkaTemplate.send("caloriesCalculationResult", destinationId, result);

  }
}
