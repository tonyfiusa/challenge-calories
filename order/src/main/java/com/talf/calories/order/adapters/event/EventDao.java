package com.talf.calories.order.adapters.event;

import com.talf.calories.order.business.dao.NotificationDao;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventDao implements NotificationDao {

  private final KafkaTemplate<Long, String> kafkaTemplate;

  public EventDao(KafkaTemplate<Long, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void notifyCaloriesCalculation(long orderId, List<Long> itemsIds) {
    this.kafkaTemplate.send("caloriesCalculation", orderId, itemsIds.stream().map(Object::toString).collect(Collectors.joining(",")));
  }
}
