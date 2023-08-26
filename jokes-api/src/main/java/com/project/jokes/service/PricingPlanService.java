package com.project.jokes.service;

import com.project.jokes.contstants.PricingPlan;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PricingPlanService {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();

    public Bucket resolveBucket(String apiKey) {
        return cache.computeIfAbsent(apiKey, this::newBucket);
    }

    public Bucket newBucket(String apiKey) {
        PricingPlan pricingPlan = PricingPlan.resolvePlanFromApiKey(apiKey);
        Integer pricingPlanValue = pricingPlan.getValue();
        Bandwidth limit = Bandwidth.classic(pricingPlanValue, Refill.intervally(pricingPlanValue, Duration.ofHours(1)));
        return Bucket.builder()
                .addLimit(limit)
                .build();
    }
}
