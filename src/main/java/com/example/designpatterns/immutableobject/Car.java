package com.example.designpatterns.immutableobject;

public class Car
{

	private String carType;
	
	public Car(String carType) {
		this.carType = carType;
	}
	
	/**
	 * Copy constructor
	 */
	public Car(Car car)
	{
		this(car.getCarType());
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	protected Car clone() throws CloneNotSupportedException {		
		return new Car(carType);
	}
	
	

}
