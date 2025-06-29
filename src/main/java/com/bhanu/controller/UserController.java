package com.bhanu.controller;

import com.bhanu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
public class UserController {

  @Autowired
  private UserService userService;

  // This will be timed by the controller pointcut
  @GetMapping("{id}")
  public String getUser(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("{id}/process")
  public String processUser(@PathVariable Long id) {
    String user = userService.getUserById(id);
    userService.processUserData(user);
    return "Processed: " + user;
  }
}
