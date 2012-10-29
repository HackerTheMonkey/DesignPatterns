package com.example.designpatterns.flyweight;

import java.util.HashMap;

public class FlyweightFactory {

	HashMap<String, Flyweight> flyweightStore;
	
	private FlyweightFactory()
	{
		flyweightStore = new HashMap<String, Flyweight>();
	}
	
	public static FlyweightFactory newInstance() {
		return new FlyweightFactory();
	}

	public Flyweight getFlyweight(String division) {		
		Flyweight flyweight = flyweightStore.get(division);
		if(flyweight == null){
			flyweight = new FlyweightImpl(division);			
			flyweightStore.put(division, flyweight);			
		}
		return flyweight;
	}
	
	private class FlyweightImpl implements Flyweight
	{
		
		private String address;
		private String city;
		private String postcode;
		private String division;
		
		
		private FlyweightImpl(String division)
		{
			if("LBi-Technology".equals(division))
			{
				setData("146 BrickLane", "London", "LBi-Technology", "E16RU");
			}
			else if("LBi-HR".equals(division))
			{
				setData("200 BrickLane", "London", "LBi-HR", "E16RU");				
			}
		}
		
		private void setData(String address, String city, String postcode, String division)
		{
			this.address = address;
			this.city = city;
			this.postcode = postcode;
			this.division = division;
		}
		
		@Override
		public String getAddress() {
			return address;
		}

		@Override
		public String getCity() {
			return city;
		}

		@Override
		public String getPostcode() {
			return postcode;
		}

		@Override
		public String getDivision() {
			return division;
		}
		
	}

}
