package com.example.designpatterns.memento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataConverter 
{	
	private static final String COMMA = ",";
	private static final String INPUT_DATA_FILE = "/Users/khafaji/tmp/raw_data.txt";
	private static final String OUTPUT_DATA_FILE = "/Users/khafaji/tmp/sql_inserts.txt";
	
	public boolean process() throws IOException 
	{					
		return generateCustomers(INPUT_DATA_FILE).writeTo(OUTPUT_DATA_FILE);
	}

	private Customers<Customer> generateCustomers(String inputDataFile) throws IOException {
		Customers<Customer> customers = new Customers<Customer>();
		
		File inputFile = new File(INPUT_DATA_FILE);
		BufferedReader inputFileBufferedReader = new BufferedReader(new FileReader(inputFile));
		
		String line;		
		while((line = inputFileBufferedReader.readLine()) != null)
		{												
			StringTokenizer inputFields = new StringTokenizer(line, COMMA);
			
			String id = inputFields.nextToken();
			String firstName = inputFields.nextToken();
			String lastName = inputFields.nextToken();
			String creditCardNumber = inputFields.nextToken();
						
			customers.add(new Customer(firstName, lastName, creditCardNumber));			
		}
		
		inputFileBufferedReader.close();
		return customers;
	}

}
