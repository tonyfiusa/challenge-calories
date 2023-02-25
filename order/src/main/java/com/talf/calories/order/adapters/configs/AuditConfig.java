package com.talf.calories.order.adapters.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AuditConfig {

  @Bean
  public AuditorAware<Long> auditorProvider() {
    return () -> {
      //TODO: fetch from security context holder after security is added
      return Optional.of(1L);
    };
  }
}
