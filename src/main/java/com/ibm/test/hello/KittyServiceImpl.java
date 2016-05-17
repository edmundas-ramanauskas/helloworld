package com.ibm.test.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by edmundas on 16.5.17.
 */
@Service
public class KittyServiceImpl implements KittyService {

    private final Logger logger = LoggerFactory.getLogger(KittyServiceImpl.class);

    @Value("classpath:static/hellokitty.jpg")
    private Resource kittyFile;

    @Override
    public byte[] getKitty() throws IOException {
        // This InputStream based solution is required in case of JAR packaging
        InputStream inputStream = kittyFile.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        // If DataInputStream isn't used - only partial image is returned
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        dataInputStream.readFully(bytes);
        return bytes;
    }
}
