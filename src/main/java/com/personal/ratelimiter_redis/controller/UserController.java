package com.personal.ratelimiter_redis.controller;

import com.personal.ratelimiter_redis.entity.User;
import com.personal.ratelimiter_redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
}
