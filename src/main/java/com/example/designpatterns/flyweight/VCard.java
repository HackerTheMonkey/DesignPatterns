package com.example.designpatterns.flyweight;

public class VCard 
{
	private Flyweight flyweight;
	private String jobTitle;
	private String employeeName;
	
	public VCard(Flyweight flyweight, String employeeName, String jobTitle) 
	{
		this.employeeName = employeeName;
		this.jobTitle = jobTitle;
		this.flyweight = flyweight;
	}

	public String getAddress() 
	{
		return flyweight.getAddress();
	}

	public String getCity() {
		return flyweight.getCity();
	}

	public String getPostcode() {
		return flyweight.getPostcode();
	}
	
	public String getEmployeeName(){
		return employeeName;
	}
	
	public String getJobTitle(){
		return jobTitle;
	}
	
	public String getDivision(){
		return flyweight.getDivision();
	}

}
