package com.gasparbarancelli.retry;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class RetryDemoDeclarativeTest {

    @SpyBean
    private RetryDemoDeclarative retryDemo;

    @Test
    void retryConfig() {
        List<String> list = retryDemo.retryable();
        verify(retryDemo).recover(any());
        assertEquals("blog", list.get(0));
    }

}