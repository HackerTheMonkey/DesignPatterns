package com.example.designpatterns.memento;

public class Customer {

	private String firstName;
	private String lastName;
	private String creditCardNumber;
	
	public Customer(String firstName, String lastName, String creditCardNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creditCardNumber = creditCardNumber;
	}

	public String getSql() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("insert into CUSTOMER_TABLE values (");
		stringBuilder.append("'" + firstName + "',");
		stringBuilder.append("'" + lastName + "',");
		stringBuilder.append("'" + creditCardNumber + "');\n");
		
		
		return stringBuilder.toString();
	}

}
