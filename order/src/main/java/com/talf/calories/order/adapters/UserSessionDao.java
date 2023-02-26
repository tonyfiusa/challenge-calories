package com.talf.calories.order.adapters;

import com.talf.calories.order.business.dao.UserDao;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserSessionDao implements UserDao {
  @Override
  public long getCurrentUserId() {
    JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    return authentication.getToken().getClaim("uid");
  }
}
