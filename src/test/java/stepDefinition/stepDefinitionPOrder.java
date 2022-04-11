package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.SerializationAddPlace;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.UtilsStoringcdata;

public class stepDefinitionPOrder extends UtilsStoringcdata {
//	RequestSpecification res;
	ResponseSpecification resspe;
	Response response;
	TestDataBuild data = new TestDataBuild();
	JsonPath js;
	static String place_id;


	@Given("Add Place Payload with (.*), (.*) and (.*)")
	public void add_place_payload(String name, String langauge, String address) throws IOException {

		resspe = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		req = given().spec(requestSpecificationMethod()).body(data.addPlacePayLoad(name, langauge, address));
	}
	@When("^user calls\"([^\"]*)\"with\"([^\"]*)\"http request$")
	public void user_calls_something_with_post_http_request(String resource,String method) throws Throwable {
		//write code here that turns the phrase above into concreate actions
		//Constructor will be called with value resource which you pass
		ApiResources resourceApi=ApiResources.valueOf(resource);
		System.out.println(resourceApi.getResource());
		if(method.equalsIgnoreCase("Post"))
		{
		response = req.when().post(resourceApi.getResource());
		String responsestring = response.asString();
		System.out.println(responsestring + "for testing purpose");
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response = req.when().post(resourceApi.getResource());	
			String responsestring = response.asString();
			System.out.println(responsestring + "for testing purpose");
		}
		
	}

   @Then("^the API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code_200() throws Throwable {   
	   assertEquals(response.getStatusCode(), 200);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String keyValue, String ExpectedValue) throws Throwable {
	
		String placeid=js.get("place_id");
		System.out.println(placeid);
		//System.out.println(js.get(ResponseMSG));
		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
	}
	@Then("^Verify place_id and created maps to\"([^\"]*)\"using the\"([^\"]*)\"$")
	//public void verify_place_Id_created_maps_to_using(String ExpectedName, String resource) throws Throwable{
	public void verify_placeid_and_created_maps_tosomethingusing_thesomething(String ExpectedName, String resource) throws Throwable {
		String place_id=getJsonPath(response,"place_id");
		req=given().spec(requestSpecificationMethod()).queryParam("place_id",place_id);
		user_calls_something_with_post_http_request(resource,"Get");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,ExpectedName);
	}
	@Given("^DeletePlace Payload$")
	public void deleteplace_payload() throws IOException
     //public void deleteplace_payload() throws Throwable {
	{
		req=given().spec(requestSpecificationMethod()).body(data.deletePlacePayload(place_id));
	}

}
