package com.talf.calories.order.adapters.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AuditConfig {

  @Bean
  public AuditorAware<Long> auditorProvider() {
    return () -> {
      JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
      return Optional.of(authentication.getToken().getClaim("uid"));
    };
  }
}
