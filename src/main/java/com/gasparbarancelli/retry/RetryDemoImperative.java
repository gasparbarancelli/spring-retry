package com.gasparbarancelli.retry;

import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetryDemoImperative {

    private final ExternalService externalService;

    public RetryDemoImperative(ExternalService externalService) {
        this.externalService = externalService;
    }

    public List<String> retryable() {
        RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(3)
                .fixedBackoff(1000)
                .retryOn(RuntimeException.class)
                .build();

        return template.execute(
                ctx -> externalService.get(),
                ctx -> List.of("blog", "gasparbarancelli")
        );
    }

}
