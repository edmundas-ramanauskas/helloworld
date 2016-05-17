package com.ibm.test.hello;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edmundas on 16.5.17.
 */
public class KittyServiceImplTest {

    @Test
    public void testGetKitty() throws IOException {
        KittyService kittyService = new KittyServiceImpl();
        assertNotNull(kittyService.getKitty());
    }
}
