package com.example.designpatterns.decorator;

import com.example.designpatterns.state.LoggerFluentFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LoggersTestWithFluentFactory
{

    public static final String SAMPLE_MESSAGE = "sample message";
    private FileLogger fileLogger;
    private ConsoleLogger consoleLogger;
    private LoggerFluentFactory loggerFluentFactory;

    @Before
    public void setup()
    {
        this.fileLogger = new FileLogger();
        this.consoleLogger = new ConsoleLogger();
        this.loggerFluentFactory = new LoggerFluentFactory();
    }

    @Test
    public void create_system_under_test()
    {
        assertThat(fileLogger, is(notNullValue()));
        assertThat(consoleLogger, is(notNullValue()));
    }

    @Test
    public void should_log_message_to_file()
    {
        fileLogger.log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_message_to_console()
    {
        consoleLogger.log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_html_message_to_console()
    {
        loggerFluentFactory.toConsole().withHtmlDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_html_message_to_file()
    {
        loggerFluentFactory.toFile().withHtmlDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_message_to_console()
    {
        loggerFluentFactory.toConsole().withReverseEncryptionDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_message_to_file()
    {
        loggerFluentFactory.toConsole().withReverseEncryptionDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_html_message_to_console()
    {
        loggerFluentFactory.toConsole().withReverseEncryptionDecoration().withHtmlDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_html_message_to_file()
    {
        loggerFluentFactory.toFile().withReverseEncryptionDecoration().withHtmlDecoration().build().log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_html_abbreviated_encrypted_message_to_console()
    {
        loggerFluentFactory.toConsole().withAbbreviatedDecorator().withReverseEncryptionDecoration().withHtmlDecoration().build().log(SAMPLE_MESSAGE);
    }
}