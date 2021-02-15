package com.gasparbarancelli.retry;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalService {

    public List<String> get() {
        throw new RuntimeException();
    }

}
