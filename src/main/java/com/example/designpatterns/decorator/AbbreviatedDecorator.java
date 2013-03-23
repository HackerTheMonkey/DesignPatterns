package com.example.designpatterns.decorator;

import org.apache.commons.lang3.StringUtils;

public class AbbreviatedDecorator implements Logger{
    private Logger logger;

    public AbbreviatedDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message)
    {
        String abbreviateMessage = StringUtils.abbreviate(message, message.length() - 5);
        System.out.println("Abbreviated message: " + abbreviateMessage);
        logger.log(abbreviateMessage);
    }
}
