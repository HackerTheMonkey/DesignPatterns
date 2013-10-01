package com.example.designpatterns.singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SingletonTest {
    @Test
    public void should_create_singleton_using_final_instance_variable_approach() {
        assertThat(SingletonA.INSTANCE, is(notNullValue()));
        assertTrue(SingletonA.INSTANCE == SingletonA.INSTANCE);
    }
    
    @Test
    public void should_create_singleton_using_the_factory_method_approach() {
        assertThat(SingletonB.getInstance(), is(notNullValue()));
        assertTrue(SingletonB.getInstance() == SingletonB.getInstance());
    }
    
    @Test
    public void should_create_singleton_using_the_enum_approach(){
        assertThat(SingletonC.INSTANCE, is(notNullValue()));
        assertThat(SingletonC.INSTANCE.someInstanceMember, is(notNullValue()));
        assertThat(SingletonC.INSTANCE == SingletonC.INSTANCE, is(true));
    }
    
    @Test
    public void invoking_the_singleton_A_private_constructor_reflectively_should_throw_an_exception() throws Exception {
        Constructor<SingletonA> constructor = SingletonA.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try{
            SingletonA singletonA = constructor.newInstance();
        }
        catch(InvocationTargetException e) {
            assertThat(e.getCause().toString().equals(AssertionError.class.getName()), is(true));
            return;
        }
        fail("An AssertionError should be thrown when invoking the singleton constructor reflectively.");
    }

    @Test
    public void invoking_the_singleton_B_private_constructor_reflectively_should_throw_an_exception() throws Exception {
        Constructor<SingletonB> constructor = SingletonB.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try{
            SingletonB singletonB = constructor.newInstance();
        }
        catch(InvocationTargetException e) {
            assertThat(e.getCause().toString().equals(AssertionError.class.getName()), is(true));
            return;
        }
        fail("An AssertionError should be thrown when invoking the singleton constructor reflectively.");
    }
    
    @Test
    public void serializing_and_deserializing_SingletonA_instance_should_not_create_a_totally_new_object() throws Exception {
        SingletonA originalInstance = SingletonA.INSTANCE;
        serialize(originalInstance);
        SingletonA deserializedSingletonA = (SingletonA) deserialize();
        assertTrue(deserializedSingletonA == originalInstance);
        assertThat(deserializedSingletonA.someInstanceMember, is(notNullValue()));
    }

    @Test
    public void serializing_and_deserializing_SingletonB_instance_should_not_create_a_totally_new_object() throws Exception {
        SingletonB originalInstance = SingletonB.getInstance();
        serialize(originalInstance);
        SingletonB deserializedSingletonB = (SingletonB) deserialize();
        assertTrue(deserializedSingletonB == originalInstance);
        assertThat(deserializedSingletonB.someInstanceMember, is(notNullValue()));
    }

    @Test
    public void serializing_and_deserializing_SingletonC_instance_should_not_create_a_totally_new_object() throws Exception {
        SingletonC originalInstance = SingletonC.INSTANCE;
        serialize(originalInstance);
        SingletonC deserializedSingletonC = (SingletonC) deserialize();
        assertTrue(deserializedSingletonC == originalInstance);
        assertThat(deserializedSingletonC.someInstanceMember, is(notNullValue()));
        assertThat(deserializedSingletonC instanceof MyInterface, is(true));
    }

    private Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("serialized_singleton_instance.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    private void serialize(Object instance) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("serialized_singleton_instance.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(instance);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
