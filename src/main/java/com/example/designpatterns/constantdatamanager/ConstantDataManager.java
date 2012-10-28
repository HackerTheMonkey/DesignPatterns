package com.example.designpatterns.constantdatamanager;

public class ConstantDataManager 
{	
	public static class Account
	{
		static final String ACCOUNT_DATA_FILE = "ACCOUNT.TXT";
		static final int VALID_MIN_LNAME_LEN = 2;	
	}
	
	public static class Address
	{
		final static String ADDRESS_DATA_FILE = "ADDRESS.TXT";
		final static String VALID_ZIP_CHARS = "0123456789";
		final static String DEFAULT_COUNTRY = "USA";
		public static final int VALID_STREET_LENGTH = 2;
	}
	
	public static class CreditCard
	{
		static final String CC_DATA_FILE = "CC.TXT";
		static final String VALID_CC_CHARS = "0123456789";
		static final String MASTER = "MASTER";
		static final String VISA = "VISA";
		static final String DISCOVER = "DISCOVER";
	}
}
