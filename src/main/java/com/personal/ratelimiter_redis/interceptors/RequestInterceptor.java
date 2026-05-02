package com.personal.ratelimiter_redis.interceptors;

import com.personal.ratelimiter_redis.service.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    private final RateLimiterService rateLimiterService;

    public RequestInterceptor(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String userId = request.getHeader("userId"); // or JWT

        if (!rateLimiterService.isAllowed(userId)) {
            response.setStatus(429);
            response.getWriter().write("Too many requests");
            return false;
        }

        return true;
    }
}
