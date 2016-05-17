package com.ibm.test.hello;

import org.springframework.stereotype.Service;

/**
 * Created by edmundas on 16.5.17.
 */
@Service
public class HelloServiceImpl implements HelloService {

    private static final String PREFIX = "Hello";
    private static final String SUFFIX = "!";
    private static final String DELIMITER = " ";

    @Override
    public HelloModel sayHello(String name) {
        String message = String.join(DELIMITER, PREFIX, name, SUFFIX);
        return new HelloModel(message);
    }
}
