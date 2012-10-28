package com.example.designpatterns.constantdatamanager;

public class CreditCard 
{	
	public void save()
	{
		System.out.println("Saving the credit card information...");
		System.out.println("CC_DATA_FILE: " + ConstantDataManager.CC_DATA_FILE);
		System.out.println("VALID_CC_CHARS: " + ConstantDataManager.VALID_CC_CHARS);
		System.out.println("MASTER: " + ConstantDataManager.MASTER);
		System.out.println("VISA: " + ConstantDataManager.VISA);
		System.out.println("DISCOVER: " + ConstantDataManager.DISCOVER);
	}
}
