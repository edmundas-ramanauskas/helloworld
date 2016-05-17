package com.ibm.test.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by edmundas on 16.5.17.
 */
@RestController
public class HelloController {
    // TODO: add error handling

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private static final String DEFAULT_NAME = "World";

    private HelloService helloService;
    private KittyService kittyService;

    @Autowired
    public HelloController(HelloService helloService, KittyService kittyService) {
        this.helloService = helloService;
        this.kittyService = kittyService;
    }

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public HelloModel helloWorld() {
        logger.info("GET /helloworld");
        return helloService.sayHello(DEFAULT_NAME);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public HelloModel hello(@RequestParam(value="name", defaultValue=DEFAULT_NAME) String name) {
        logger.info("POST /hello {}", name);
        return helloService.sayHello(name);
    }

    @RequestMapping(value = "/hellokitty", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] helloKitty() throws IOException {
        logger.info("GET /hellokitty");
        return kittyService.getKitty();
    }
}
