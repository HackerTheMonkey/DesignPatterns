package com.example.designpatterns.memento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is designed using the Decorator design
 * pattern
 *
 * Note: The reason we extending ArrayList here is to have a similar
 * interface and not to extend the functionality of the superclass. We
 * are extending the functionality of the wrapped @List<Customer> instead.
 */
public class Customers<T extends Customer> extends ArrayList<T>
{	
	private static final long serialVersionUID = 5006003350007895213L;
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	@Override
	public boolean add(T customer) { 
		return customers.add(customer);
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	public DataWritingResponse writeTo(String outputDataFile) throws IOException
	{ 
		File outputFile = new File(outputDataFile);

        PrintWriter outputFilePrintStream = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));

        int lastProcesedRecord = 0;

        for (Customer customer : customers) {
            Validator customerValidator = new CustomerValidator();

            if (customerValidator.isValid(customer)) {
                outputFilePrintStream.append(customer.getSql());
                outputFilePrintStream.flush();
                lastProcesedRecord = customer.getLastProcessedRecord();
            } else {
                return new DataWritingResponse(false, lastProcesedRecord);
            }
        }

        //outputFilePrintStream.flush();
        outputFilePrintStream.close();

        return new DataWritingResponse(true, lastProcesedRecord);
	}

	@Override
	public int size() {	
		return customers.size();
	}
	
	/**
	 * TODO implement/override the rest of the methods as needed
	 */

}
