package com.example.designpatterns.constantdatamanager;

public class Address 
{
	/**
	 * @deprecated Use {@link ConstantDataManager#ADDRESS_DATA_FILE} instead
	 */
	private final static String ADDRESS_DATA_FILE = ConstantDataManager.ADDRESS_DATA_FILE;
	/**
	 * @deprecated Use {@link ConstantDataManager#VALID_STREET_LENGTH} instead
	 */
	private final static int VALID_STREET_LENGTH = ConstantDataManager.VALID_STREET_LENGTH;
	/**
	 * @deprecated Use {@link ConstantDataManager#VALID_ZIP_CHARS} instead
	 */
	private final static String VALID_ZIP_CHARS = ConstantDataManager.VALID_ZIP_CHARS;
	/**
	 * @deprecated Use {@link ConstantDataManager#DEFAULT_COUNTRY} instead
	 */
	private final static String DEFAULT_COUNTRY = ConstantDataManager.DEFAULT_COUNTRY;
	
	
	public void save()
	{
		System.out.println("Saving the address information...");
		System.out.println("ADDRESS_DATA_FILE: " + ConstantDataManager.ADDRESS_DATA_FILE);
		System.out.println("VALID_STREET_LENGTH: " + ConstantDataManager.VALID_STREET_LENGTH);
		System.out.println("VALID_ZIP_CHARS: " + ConstantDataManager.VALID_ZIP_CHARS);
		System.out.println("DEFAULT_COUNTRY: " + ConstantDataManager.DEFAULT_COUNTRY);
	}
}
