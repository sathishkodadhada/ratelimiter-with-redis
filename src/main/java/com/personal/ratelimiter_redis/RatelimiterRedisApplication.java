package com.personal.ratelimiter_redis;

import com.personal.ratelimiter_redis.entity.User;
import com.personal.ratelimiter_redis.interceptors.RequestInterceptor;
import com.personal.ratelimiter_redis.service.RateLimiterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@ComponentScan("com.personal.ratelimiter_redis")
public class RatelimiterRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatelimiterRedisApplication.class, args);
    }

//    @Bean(name = "userRedisTemplate")
//    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, User> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JacksonJsonRedisSerializer(User.class));
//
//        template.afterPropertiesSet();
//
//        return template;
//    }
//
//    @Bean(name = "rateLimitTemplate")
//    public RedisTemplate<String, Object> rateLimitTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//
//        return template;
//    }
//
//    @Bean
//    RequestInterceptor requestInterceptor(RateLimiterService rateLimiterService) {
//        return new RequestInterceptor(rateLimiterService);
//    }
}
