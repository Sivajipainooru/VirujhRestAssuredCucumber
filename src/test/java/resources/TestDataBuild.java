package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.SerializationAddPlace;

public class TestDataBuild {
	public SerializationAddPlace addPlacePayLoad(String name,String langauge,String address)
	{
		SerializationAddPlace sap=new SerializationAddPlace();
	   	 sap.setAccuracy(50);
	   	 sap.setAddress(address);
	   	 sap.setLangauge(langauge);
	   	 sap.setPhoneNumber("(+91) 983 893 3937");
	   	 sap.setWebsite("https://rahulshettyacademy.com");
	   	 sap.setName(name);
	   	 List<String> myList=new ArrayList<String>();
	   	 myList.add("shoe park");
	   	 myList.add("shop");
	   	 sap.setTypes(myList);
	   	 Location l=new Location();
	   	 l.setLat(-38.383494);
	   	 l.setLog(33.436787);
	   	 sap.setLocations(l);
	   	 return sap;
	}
	public String deletePlacePayload(String placeid)
	{
		return "{\r\n \"place_id\": \""+placeid+"\"\r\n}";
	}

}
