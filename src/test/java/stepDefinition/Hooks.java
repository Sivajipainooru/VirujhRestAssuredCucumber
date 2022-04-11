package stepDefinition;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {
	//@DeletePlace
	@Before("@AddPlaceApi")
	public void beforeScenario() throws Throwable
	{
		//executing this code when addplace is null
		//write a code that will be give to you a placeid
		stepDefinitionPOrder s=new stepDefinitionPOrder();
		if(s.place_id==null)
		{
		s.add_place_payload("shety", "malayalam", "Asia");
		s.user_calls_something_with_post_http_request("addPlaceApi","POST");
		s.verify_placeid_and_created_maps_tosomethingusing_thesomething("shety", "getPlaceApi");
		}
		
	}

}
