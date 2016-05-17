package com.ibm.test.hello;

import com.ibm.test.GreetingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by edmundas on 16.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingApplication.class)
public class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testSayHello() {
        assertEquals("Hello World !", helloService.sayHello("World").getMessage());
        assertEquals("Hello  !", helloService.sayHello("").getMessage());
    }
}
