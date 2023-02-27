package com.talf.calories.web.config;

import com.talf.calories.product.ApiClient;
import com.talf.calories.product.api.BeverageApiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeverageApi {

  @Value("${api.product.url}")
  public String productApiUrl;

  @Bean
  @Primary
  public BeverageApiApi beverageApiApi(@Autowired RestTemplate restTemplate) {
    ApiClient apiClient = new ApiClient(restTemplate);
    apiClient.setBasePath(productApiUrl);
    return new BeverageApiApi(apiClient);
  }
}
