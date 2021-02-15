package com.gasparbarancelli.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RetryDemoDeclarativeCustomConfigWithProperties {

    private final ExternalService externalService;

    public RetryDemoDeclarativeCustomConfigWithProperties(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Retryable(
            value = RuntimeException.class,
            maxAttemptsExpression = "${config.retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${config.retry.maxDelay}")
    )
    public List<String> retryable() {
        return externalService.get();
    }

    @Recover
    public List<String> recover(RuntimeException e) {
        return Collections.emptyList();
    }

}
