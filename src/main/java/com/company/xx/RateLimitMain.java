package com.company.xx;

@RateLimit(value = 666)
public class RateLimitMain {

    public static void main(String[] args) {
        RateLimit rateLimit = RateLimitMain.class.getAnnotation(RateLimit.class);
        System.out.println(rateLimit.value());
    }
}
