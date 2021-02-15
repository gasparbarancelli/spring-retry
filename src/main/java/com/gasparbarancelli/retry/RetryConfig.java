package com.gasparbarancelli.retry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfig {

    @Value("${config.retry.maxAttempts}")
    private int maxAttempts;

    @Value("${config.retry.maxDelay}")
    private long maxDelay;

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(maxDelay);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        retryTemplate.setRetryPolicy(new SimpleRetryPolicy(maxAttempts));

        return retryTemplate;
    }

}
