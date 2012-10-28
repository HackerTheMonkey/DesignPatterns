package com.example.designpatterns.constantdatamanager;

public class CreditCard 
{	
	public void save()
	{
		System.out.println("Saving the credit card information...");
		System.out.println("CC_DATA_FILE: " + ConstantDataManager.CreditCard.CC_DATA_FILE);
		System.out.println("VALID_CC_CHARS: " + ConstantDataManager.CreditCard.VALID_CC_CHARS);
		System.out.println("MASTER: " + ConstantDataManager.CreditCard.MASTER);
		System.out.println("VISA: " + ConstantDataManager.CreditCard.VISA);
		System.out.println("DISCOVER: " + ConstantDataManager.CreditCard.DISCOVER);
	}
}
