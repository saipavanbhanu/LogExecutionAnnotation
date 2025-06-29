package com.bhanu.service;

import com.bhanu.annotations.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @LogExecutionTime
  public String getUserById(Long id) {
    // Simulate some processing time
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    return "User-" + id;
  }

  @LogExecutionTime
  public void processUserData(String userData) {
    // Simulate processing
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}