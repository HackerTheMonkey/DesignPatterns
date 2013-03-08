package com.example.designpatterns.state;

import com.example.designpatterns.decorator.*;

public class LoggerFluentFactory
{
    private Logger logger;

    public LoggerFluentFactory withHtmlDecoration() {
        logger = new HtmlDecorator(logger);
        return this;
    }

    public Logger build() {
        return logger;
    }

    public LoggerFluentFactory toConsole()
    {
        logger = new ConsoleLogger();
        return this;
    }

    public LoggerFluentFactory toFile() {
        logger = new FileLogger();
        return this;
    }

    public LoggerFluentFactory withReverseEncryptionDecoration() {
        logger = new ReverseEncryptionDecorator(logger);
        return this;
    }

    public LoggerFluentFactory withAbbreviatedDecorator() {
        logger = new AbbreviatedDecorator(logger);
        return this;
    }
}
