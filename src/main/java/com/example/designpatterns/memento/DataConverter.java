package com.example.designpatterns.memento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter 
{	
	private static final String COMMA = ",";
	private String inputDataFile = "/Users/khafaji/tmp/raw_data.txt";
	private static final String OUTPUT_DATA_FILE = "/Users/khafaji/tmp/sql_inserts.txt";
    private int lastProcessedId;

    public DataConverter()
	{
		
	}
	
	public DataConverter(String inputDataFile) {
		this.inputDataFile = inputDataFile;
	}

	public boolean process() throws IOException 
	{
        DataWritingResponse dataWritingResponse = generateCustomers(inputDataFile).writeTo(OUTPUT_DATA_FILE);
        setLastProcessedId(dataWritingResponse.getLastProcesedRecord());

        return dataWritingResponse.getProcessingResult();
	}

	private Customers<Customer> generateCustomers(String inputDataFile) throws IOException 
	{
		Customers<Customer> customers = new Customers<Customer>();
		
		File inputFile = new File(this.inputDataFile);
		BufferedReader inputFileBufferedReader = new BufferedReader(new FileReader(inputFile));
		
		String line;		
		while((line = inputFileBufferedReader.readLine()) != null)
		{
            String[] customerDetails = line.split(COMMA);

			int id = Integer.parseInt(customerDetails[0]);
            if (id > lastProcessedId) {
                String firstName = customerDetails[1];
                String lastName = customerDetails[2];
                String creditCardNumber = customerDetails[3];

                customers.add(new Customer(firstName, lastName, creditCardNumber, id));
            }
        }
		
		inputFileBufferedReader.close();
		return customers;
	}

    private void setLastProcessedId(int lastProcessedId)
    {
        this.lastProcessedId = lastProcessedId;
    }

    public void setInputFile(String inputDataFile)
    {
        this.inputDataFile = inputDataFile;
    }

	public int getLastProcessedId() {
		return lastProcessedId;
	}

    public Memento getMemento() {
        return new Memento(getLastProcessedId());
    }

    public void setMemento(Memento memento) {
        this.lastProcessedId = memento.id;
    }

    public class Memento
    {
        private final int id;

        private Memento(int id){
            this.id = id;
        }

    }
}