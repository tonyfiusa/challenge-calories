package com.talf.calories.user.adapters.config;

import com.talf.calories.user.adapters.CustomUserDetails;
import com.talf.calories.user.business.GetUserInfoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.util.Optional;


@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(authorize ->
        authorize.anyRequest().authenticated()
      )
      .formLogin(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  UserDetailsService users(@Autowired GetUserInfoUseCase getUserInfoUseCase) {
    return username -> {
      Optional<com.talf.calories.user.entities.User> user = getUserInfoUseCase.get(username);
      return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    };
  }

  @Bean
  SessionRegistry sessionRegistry() {
    return new SessionRegistryImpl();
  }

  @Bean
  HttpSessionEventPublisher httpSessionEventPublisher() {
    return new HttpSessionEventPublisher();
  }
}
