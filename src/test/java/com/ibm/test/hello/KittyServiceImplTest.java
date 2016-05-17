package com.ibm.test.hello;

import com.ibm.test.GreetingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edmundas on 16.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingApplication.class)
public class KittyServiceImplTest {

    @Autowired
    private KittyService kittyService;

    @Test
    public void testGetKitty() throws IOException {
        assertNotNull(kittyService.getKitty());
    }
}
