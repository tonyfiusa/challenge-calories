package com.talf.calories.product.adapters.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;
  @Value(value = "${spring.kafka.consumer.group-id}")
  private String groupId;

  @Bean
  public ProducerFactory<Long, Long> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(
      ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
      bootstrapAddress);
    configProps.put(
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      LongSerializer.class);
    configProps.put(
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
      LongSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<Long, Long> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
      bootstrapAddress);
    props.put(
      ConsumerConfig.GROUP_ID_CONFIG,
      groupId);
    props.put(
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
      LongDeserializer.class);
    props.put(
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
      StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(props);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String>
  kafkaListenerContainerFactory() {

    ConcurrentKafkaListenerContainerFactory<String, String> factory =
      new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public NewTopic caloriesCalculation() {
    return new NewTopic("caloriesCalculationResult", 1, (short) 1);
  }
}
