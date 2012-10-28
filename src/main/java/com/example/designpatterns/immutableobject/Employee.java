package com.example.designpatterns.immutableobject;

public final class Employee 
{
	/**
	 * Object state - instance variables
	 */
	private final String firstName;
	private final String lastName;
	private final String SSN;
	private final String address;
	private final Car car;
	
	public Employee(String firstName, String lastName, String SSN, String address, Car car)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.address = address;
		this.car = car;
	}	

	/**
	 * Getters and setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSSN() {
		return SSN;
	}

	public String getAddress() {
		return address;
	}

	public Car getCar() throws CloneNotSupportedException {
		return car.clone(); // or new Car(car);  // Using the Car's copy constructor
	}

	
}
