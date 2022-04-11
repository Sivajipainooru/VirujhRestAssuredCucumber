package stepDefinition;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import Pojo.Location;
import Pojo.SerializationAddPlace;

@RunWith(Cucumber.class)
public class stepDefinitionPlaceOrder {
	  RequestSpecification res;
	  ResponseSpecification resspe;
	  Response response;
	  @Given("^Add Place Payload$")
  
	  public void add_place_payload() throws Throwable {
    	 RestAssured.baseURI="https://rahulshettyacademy.com";
    	 SerializationAddPlace sap=new SerializationAddPlace();
    	 sap.setAccuracy(50);
    	 sap.setAddress("29, side layout, cohen 09");
    	 sap.setLangauge("French-In");
    	 sap.setPhoneNumber("(+91) 983 893 3937");
    	 sap.setWebsite("https://rahulshettyacademy.com");
    	 sap.setName("Front line house");
    	 List<String> myList=new ArrayList<String>();
    	 myList.add("shoe park");
    	 myList.add("shop");
    	 sap.setTypes(myList);
    	 Location l=new Location();
    	 l.setLat(-38.383494);
    	 l.setLog(33.436787);
    	 sap.setLocations(l);
    	 RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
    	 .setContentType(ContentType.JSON).build();
    	resspe=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	res= given().spec(req).body(sap);
    }

	  @When("^ user calls \"([^\"]*)\" with Post http request$")
	    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
    	response=res.when().post("/maps/api/place/add/json").then().log().all().spec(resspe).extract().response();
    	String responsestring=response.asString();
    	System.out.println(responsestring+"for testing purpose");
    }

	  @Then("^the API call got success with status code 200$")
	    public void the_api_call_got_success_with_status_code_200() throws Throwable {
       assertEquals(response.getStatusCode(),200);
    }

	  @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {
        String ResponseMSG=response.asString();
        JsonPath js=new JsonPath(ResponseMSG);
        System.out.println(js.get(ResponseMSG));
    }

}

//
//
//	resspe=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//
//baseUrl=https://rahulshettyacademy.com
//
//"/maps/api/place/add/json";
//"/maps/api/place/get/json";
//"/maps/api/place/delete/json";
//
//@Then("verify place_Id created maps to {string} using {string}")
//public void verify_place_Id_created_maps_to_using(String string, String string2){
//}
//
//Scenario: Verify if Delete Place functionality is working
//Given DeletePlace Payload
//When user calls  "deletePlaceApi" with "Post" http request
//Then the Api call got success with status code 200
//And "Status" in response body is "OK"
//geki hands
//,plugin="json:target/jsonReports/cucumber-report.json",
//
//https://jenkins.io/download/
//java -jar jenkins.war -httpPort-9090
//https://www.saucedemo.com/