package com.project.jokes.config;

import com.project.jokes.interceptor.PremiumApiInterceptor;
import com.project.jokes.interceptor.RateLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private RateLimitInterceptor interceptor;

    @Autowired
    private PremiumApiInterceptor premiumApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/api/v2/jokes/**");
        registry.addInterceptor(premiumApiInterceptor)
                .addPathPatterns("/api/premium/jokes/**");
    }
}
