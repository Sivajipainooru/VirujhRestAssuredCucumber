package resources;
//enum is a special class of java which can be collections of constants and methods
public enum ApiResources {
	AddPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	private String resource;
	ApiResources(String resource)
	{
		this.resource=resource;
		
	}
	public String getResource()
	{
		return resource;
	}

}
