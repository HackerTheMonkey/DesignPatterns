package com.example.designpatterns.constantdatamanager;

public class Account 
{
	/**
	 * @deprecated Use {@link ConstantDataManager#ACCOUNT_DATA_FILE} instead
	 */
	private static final String ACCOUNT_DATA_FILE = ConstantDataManager.ACCOUNT_DATA_FILE;
	/**
	 * @deprecated Use {@link ConstantDataManager#VALID_MIN_LNAME_LEN} instead
	 */
	private static final int VALID_MIN_LNAME_LEN = ConstantDataManager.VALID_MIN_LNAME_LEN;
	
	public void save()
	{
		System.out.println("Saving the account information...");
		System.out.println("ACCOUNT_DATA_FILE: " + ConstantDataManager.ACCOUNT_DATA_FILE);
		System.out.println("VALID_MIN_LNAME_LEN: " + ConstantDataManager.VALID_MIN_LNAME_LEN);
	}
}
