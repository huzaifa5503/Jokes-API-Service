package com.project.jokes.contstants;

public enum PricingPlan {

    FREE(20),
    BASIC(40),
    PROFESSIONAL(100);

    private final int value;

    private PricingPlan(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static PricingPlan resolvePlanFromApiKey(String apiKey) {
        if (apiKey.startsWith("FX001-")) {
            return FREE;
        } else if (apiKey.startsWith("PX001-")) {
            return PROFESSIONAL;
        } else if (apiKey.startsWith("BX001-")) {
            return BASIC;
        }
        return FREE;
    }

}
