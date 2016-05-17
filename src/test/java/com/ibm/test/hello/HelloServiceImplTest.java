package com.ibm.test.hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by edmundas on 16.5.17.
 */
public class HelloServiceImplTest {

    @Test
    public void testSayHello() {
        HelloService helloService = new HelloServiceImpl();
        assertEquals("Hello World !", helloService.sayHello("World").getMessage());
        assertEquals("Hello  !", helloService.sayHello("").getMessage());
    }
}
