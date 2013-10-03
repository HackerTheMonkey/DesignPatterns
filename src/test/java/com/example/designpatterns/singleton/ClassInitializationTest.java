package com.example.designpatterns.singleton;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassInitializationTest {

    @Test
    public void creating_a_new_instance_using_new_operator_should_result_in_static_followed_by_non_static_initialization_of_a_class_parent_then_child(){
        new Child();
    }

    @Test
    public void creating_a_new_instance_of_a_class_using_reflection_should_result_in_static_followed_by_non_static_initialization_of_a_class_parent_then_child() throws Exception{
        Child.class.getConstructor().newInstance();
    }

    @Test
    public void assigning_a_static_field_should_trigger_static_initialization_only() {
        Child.foo = "baz";
        assertThat(Child.foo, is(equalTo("baz")));
    }

    @Test
    public void using_a_non_constant_static_field_should_trigger_static_initialization_only(){
        System.out.println("Testing: " + Child.foo);
    }
    
    @Test
    public void simply_referencing_a_class_should_not_trigger_any_initialization(){
        Child foo = null;
        Parent bar = null;
        System.out.println(foo);
        System.out.println(bar);
    }
    
    @Test
    public void accessing_a_parent_static_field_through_child_should_trigger_parent_static_initialization_only(){
        System.out.println(Child.fooBar);        
    }
    
    @Test
    public void accessing_a_compile_time_constant_through_child_or_parent_should_not_trigger_any_initialization(){
        System.out.println(Child.fooBarBaz);
        System.out.println(Parent.fooBarBaz);
    }

}
