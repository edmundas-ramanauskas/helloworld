package com.ibm.test.hello;

/**
 * Created by edmundas on 16.5.17.
 */
public class HelloModel {
    private String message;

    public HelloModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
