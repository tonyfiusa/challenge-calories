package com.talf.calories.web.config;

import com.talf.calories.order.ApiClient;
import com.talf.calories.order.api.OrderApiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderApi {

  @Value("${api.order.url}")
  public String orderApiUrl;

  @Bean
  @Primary
  public OrderApiApi orderApiApi(@Autowired RestTemplate restTemplate) {
    ApiClient apiClient = new ApiClient(restTemplate);
    apiClient.setBasePath(orderApiUrl);
    return new OrderApiApi(apiClient);
  }
}
