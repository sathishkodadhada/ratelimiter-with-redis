package com.personal.ratelimiter_redis.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RateLimiterService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final Integer LIMIT = 10;
    private static final int WINDOW = 60; // seconds

    public RateLimiterService(@Qualifier("rateLimitTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean isAllowed(String userId) {
        String key = "rate_limit:" + userId;

        Long count = redisTemplate.opsForValue().increment(key);

        if (count == 1) {
            redisTemplate.expire(key, WINDOW, TimeUnit.SECONDS);
        }

        return count <= LIMIT;
    }
}
