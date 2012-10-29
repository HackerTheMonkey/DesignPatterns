package com.example.designpatterns.memento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This is a decorator on the top of an ArrayList
 * @see the decorator design pattern
 * 
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

	public boolean writeTo(String outputDataFile) throws FileNotFoundException 
	{ 
		File outputFile = new File(outputDataFile);
		PrintStream outputFilePrintStream = new PrintStream(outputFile);
		
		Iterator<Customer> customerIterator = customers.iterator();
		
		while(customerIterator.hasNext())
		{
			Customer customer = customerIterator.next();			
			outputFilePrintStream.append(customer.getSql());
		}
		
		outputFilePrintStream.flush();
		outputFilePrintStream.close();
		
		return true;
	}

	@Override
	public int size() {	
		return customers.size();
	}
	
	/**
	 * TODO implement/override the rest of the methods as needed
	 */

}
