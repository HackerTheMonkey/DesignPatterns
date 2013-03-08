package com.example.designpatterns.decorator;

import org.apache.commons.lang3.StringUtils;

public class ReverseEncryptionDecorator implements Logger{
    private Logger logger;

    public ReverseEncryptionDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        System.out.println("Reverse Encrypted message: " + (message = StringUtils.reverse(message)));
        logger.log(message);
    }
}
