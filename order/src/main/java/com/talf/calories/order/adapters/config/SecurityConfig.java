package com.talf.calories.order.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers( "/actuator/health/**").permitAll()
      .antMatchers( "/**").authenticated()
      .and()
      .oauth2ResourceServer()
      .jwt();
    return http.build();
  }
}
