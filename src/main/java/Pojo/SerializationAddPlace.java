package Pojo;

import java.util.List;

public class SerializationAddPlace {
	private int accuracy;
	private String Name;
	private String phoneNumber;
	private String address;
	private String website;
	private String langauge;
	private Location locations;
	private List<String> types;
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLangauge() {
		return langauge;
	}
	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}
	public Location getLocations() {
		return locations;
	}
	public void setLocations(Location locations) {
		this.locations = locations;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	

}
