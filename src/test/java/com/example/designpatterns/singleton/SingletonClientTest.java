package com.example.designpatterns.singleton;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * This test is attempting to test the client of a singleton class.
 * The test is injecting a mocked implementation of the singleton class
 * via Mockito framework which appears to do the required job.
 */
public class SingletonClientTest {

    private SingletonClient singletonClient;
    @Mock SingletonA mySingleton;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(mySingleton.getFoo()).thenReturn("bar");
        singletonClient = new SingletonClient(mySingleton);
    }

    @Test
    public void test(){
        assertThat(singletonClient, is(notNullValue()));
        assertThat(singletonClient.getFoo(), is(equalTo("bar")));
    }
}
