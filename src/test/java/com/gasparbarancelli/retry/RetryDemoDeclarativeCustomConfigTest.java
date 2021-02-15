package com.gasparbarancelli.retry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class RetryDemoDeclarativeCustomConfigTest {

    @SpyBean
    private RetryDemoDeclarativeCustomConfig retryDemo;

    @Test
    void retryConfig() {
        List<String> list = retryDemo.retryable();
        verify(retryDemo).recover(any());
        assertEquals("gasparbarancelli", list.get(0));
    }

}