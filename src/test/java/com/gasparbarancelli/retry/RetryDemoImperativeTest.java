package com.gasparbarancelli.retry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RetryDemoImperativeTest {

    @Autowired
    private RetryDemoImperative retryDemoImperative;

    @Test
    void retryConfig() {
        List<String> list = retryDemoImperative.retryable();
        assertEquals("blog", list.get(0));
        assertEquals("gasparbarancelli", list.get(1));
    }

}