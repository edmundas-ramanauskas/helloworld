package com.ibm.test.hello;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by edmundas on 16.5.17.
 */
@Service
public class KittyServiceImpl implements KittyService {

    private static final String FILE_PATH = "static/hellokitty.jpg";

    @Override
    public byte[] getKitty() throws IOException {
        // TODO: implement caching
        return Files.readAllBytes(Paths.get(
                getClass().getClassLoader().getResource(FILE_PATH).getFile()));
    }
}
