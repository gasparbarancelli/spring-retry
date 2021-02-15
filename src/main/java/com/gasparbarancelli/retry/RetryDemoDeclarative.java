package com.gasparbarancelli.retry;


import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
class RetryDemoDeclarative {

    private final ExternalService externalService;

    public RetryDemoDeclarative(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Retryable(RuntimeException.class)
    public List<String> retryable() {
        return externalService.get();
    }

    @Recover
    public List<String> recover(RuntimeException e) {
        return Collections.singletonList("blog");
    }

}