package com.example.designpatterns.flyweight;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VCardTest 
{
	private VCard techVCard;
	private VCard hrVCard;
	
	@Before
	public void setup()
	{
		techVCard = new VCard(FlyweightFactory.newInstance().getFlyweight("LBi-Technology"), "John", "Software Developer");
		hrVCard = new VCard(FlyweightFactory.newInstance().getFlyweight("LBi-HR"), "Alice", "HR Administrator");
	}
	
	@Test
	public void technologyVCardHasAnAddressField()
	{
		assertNotNull("VCard must have an address field", techVCard.getAddress());
	}
	
	@Test
	public void technologyVCcardHasACityField()
	{
		assertNotNull("VCard must have an city field", techVCard.getCity());
	}
	
	@Test
	public void technologyVCcardHasAPostcodeField()
	{
		assertNotNull("VCard must have a postcode field", techVCard.getPostcode());
	}
	
	@Test
	public void technologyVCcardHasEmployeeNameField()
	{
		assertNotNull("VCard must have an employee name field", techVCard.getEmployeeName());
	}
	
	@Test
	public void technologyVCcardHasJobTitleField()
	{
		assertNotNull("VCard must have a job title field", techVCard.getJobTitle());
	}
	
	@Test
	public void technologyVCcardHasDivisionField()
	{
		assertNotNull("VCard must have a division field", techVCard.getDivision());
	}
	
	@Test
	public void hrVCardHasAnAddressField()
	{
		assertNotNull("VCard must have an address field", hrVCard.getAddress());
	}
	
	@Test
	public void hrVCcardHasACityField()
	{
		assertNotNull("VCard must have an city field", hrVCard.getCity());
	}
	
	@Test
	public void hrVCcardHasAPostcodeField()
	{
		assertNotNull("VCard must have a postcode field", hrVCard.getPostcode());
	}
	
	@Test
	public void hrVCcardHasEmployeeNameField()
	{
		assertNotNull("VCard must have an employee name field", hrVCard.getEmployeeName());
	}
	
	@Test
	public void hrVCcardHasJobTitleField()
	{
		assertNotNull("VCard must have a job title field", hrVCard.getJobTitle());
	}
	
	@Test
	public void hrVCcardHasDivisionField()
	{
		assertNotNull("VCard must have a division field", hrVCard.getDivision());
	}
}
