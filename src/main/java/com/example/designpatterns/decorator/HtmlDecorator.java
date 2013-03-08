package com.example.designpatterns.decorator;

public class HtmlDecorator implements Logger
{
    private Logger consoleLogger;

    public HtmlDecorator(Logger consoleLogger)
    {
        this.consoleLogger = consoleLogger;
    }

    @Override
    public void log(String message)
    {
        System.out.println("HTML Message: " + (message = "<b>" + message + "</b>"));
        consoleLogger.log(message);
    }
}
