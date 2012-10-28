package com.example.designpatterns.immutableobject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest 
{
	private Employee employee;
	
	@Before
	public void setup()
	{
		employee = new Employee("Hasanein", "Khafaji", "123456789", "146 Bricklane, London", new Car("BMW"));
	}
	
	@Test
	public void shouldNotBeAbleToChangeCarType() throws Exception
	{
		employee.getCar().setCarType("Mercedes");
		Assert.assertEquals("Car type should be unchangable", "BMW", employee.getCar().getCarType());
	}
}
