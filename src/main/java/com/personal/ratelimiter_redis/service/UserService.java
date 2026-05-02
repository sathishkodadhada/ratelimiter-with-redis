package com.personal.ratelimiter_redis.service;

import com.personal.ratelimiter_redis.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {
    Map<String, User> userMap = new HashMap<>();
    private final RedisTemplate userRedisTemplate;

    public UserService(@Qualifier("userRedisTemplate") RedisTemplate userRedisTemplate) {
        this.userRedisTemplate = userRedisTemplate;
    }

    public User getUser(String userId) {
        User user = (User) userRedisTemplate.opsForValue().get(userId);
        System.out.println(user);
        if (user != null)
            return user;
        System.out.println("Fetching from DB");
        User user1 = fetchFromDB(userId);
        userRedisTemplate.opsForValue().set(userId, user1, Duration.ofSeconds(60));
        return user1;
    }

    private User fetchFromDB(String userId) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        return userMap.get(userId);
    }

    @PostConstruct
    void postConstruct() {
        userMap.put("1", new User("1", "SK1"));
        userMap.put("2", new User("2", "SK2"));
        userMap.put("3", new User("3", "SK3"));
        userMap.put("4", new User("4", "SK4"));
        userMap.put("5", new User("5", "SK5"));
    }
}
