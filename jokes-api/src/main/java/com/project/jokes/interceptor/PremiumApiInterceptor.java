package com.project.jokes.interceptor;

import com.project.jokes.annotations.PremiumApi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PremiumApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(PremiumApi.class)) {
                String apiKey = request.getHeader("Authorization");
                if ("PX0001".equals(apiKey)) {
                    return true; // Authentication successful
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false; // Authentication failed
                }
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}