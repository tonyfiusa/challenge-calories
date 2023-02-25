package com.talf.calories.order.adapters;

import com.talf.calories.order.business.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserSessionDao implements UserDao {
  @Override
  public long getCurrentUserId() {
    //TODO: fetch from security context holder after security is added
    return 1;
  }
}
