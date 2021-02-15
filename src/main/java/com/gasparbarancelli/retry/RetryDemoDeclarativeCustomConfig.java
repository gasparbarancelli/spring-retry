package com.gasparbarancelli.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetryDemoDeclarativeCustomConfig {

    private final ExternalService externalService;

    public RetryDemoDeclarativeCustomConfig(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Retryable(
            value = RuntimeException.class,
            maxAttempts = 2,
            backoff = @Backoff(delay = 1000)
    )
    public List<String> retryable() {
        return externalService.get();
    }

    @Recover
    public List<String> recover(RuntimeException e) {
        return List.of("gasparbarancelli");
    }

}
