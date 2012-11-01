package com.example.designpatterns.memento;

public class Customer {

	private final String firstName;
	private final String lastName;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    private final String creditCardNumber;
    private final int lastProcessedRecord;
    private final String sql;


	
	public Customer(String firstName, String lastName, String creditCardNumber, int lastProcessedRecord) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creditCardNumber = creditCardNumber;
        this.lastProcessedRecord = lastProcessedRecord;
        sql = generateSql();
    }

	public String getSql() {
        return sql;
	}

    private String generateSql() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("insert into CUSTOMER_TABLE values (");
        stringBuilder.append("'" + firstName + "',");
        stringBuilder.append("'" + lastName + "',");
        stringBuilder.append("'" + creditCardNumber + "');\n");


        return stringBuilder.toString();
    }

    public String getLastname()
	{
		return lastName;
	}

    public int getLastProcessedRecord() {
        return lastProcessedRecord;
    }
}
