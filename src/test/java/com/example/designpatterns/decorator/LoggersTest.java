package com.example.designpatterns.decorator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LoggersTest
{

    public static final String SAMPLE_MESSAGE = "sample message";
    private FileLogger fileLogger;
    private ConsoleLogger consoleLogger;

    @Before
    public void setup()
    {
        this.fileLogger = new FileLogger();
        this.consoleLogger = new ConsoleLogger();
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
        new HtmlDecorator(consoleLogger).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_html_message_to_file()
    {
        new HtmlDecorator(fileLogger).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_message_to_console()
    {
        new ReverseEncryptionDecorator(consoleLogger).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_message_to_file()
    {
        new ReverseEncryptionDecorator(fileLogger).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_html_message_to_console()
    {
        new HtmlDecorator(new ReverseEncryptionDecorator(consoleLogger)).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_encrypted_html_message_to_file()
    {
        new HtmlDecorator(new ReverseEncryptionDecorator(fileLogger)).log(SAMPLE_MESSAGE);
    }

    @Test
    public void should_log_html_abbreviated_encrypted_message_to_console()
    {
        new AbbreviatedDecorator(new ReverseEncryptionDecorator(new HtmlDecorator(consoleLogger))).log(SAMPLE_MESSAGE);
    }
}
