package com.ibm.test.hello;

import java.io.IOException;

/**
 * Created by edmundas on 16.5.17.
 */
public interface KittyService {
    byte[] getKitty() throws IOException;
}
