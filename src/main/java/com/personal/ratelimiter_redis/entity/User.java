package com.personal.ratelimiter_redis.entity;

import java.io.Serializable;

public record User(String userId, String name) implements Serializable {
}
