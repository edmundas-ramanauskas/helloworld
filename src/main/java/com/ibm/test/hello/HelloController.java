package com.ibm.test.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by edmundas on 16.5.17.
 */
@RestController
public class HelloController {

    private static final String DEFAULT_NAME = "World";

    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public HelloModel helloWorld() {
        return helloService.sayHello(DEFAULT_NAME);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public HelloModel hello(@RequestParam(value="name", defaultValue=DEFAULT_NAME) String name) {
        return helloService.sayHello(name);
    }
}
