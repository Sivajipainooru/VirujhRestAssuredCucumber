package stepDefinition;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
    import static io.restassured.RestAssured.*;
   
	import cucumber.api.junit.Cucumber;
    import org.junit.runner.RunWith;

	
	public class AddPlaceApi  {

	    @Given("^User enter the url and body data$")
	    public void user_enter_the_url_and_body_data() throws Throwable {
	    	RestAssured.baseURI="https://rahulshettyacademy.com";
	    	given().log().all().queryParams("key","qaclick123").headers("Content-Type","application/json")
	    	.body("{\r\n" + 
	    			"  \"location\": {\r\n" + 
	    			"    \"lat\": -38.383494,\r\n" + 
	    			"    \"lng\": 33.427362\r\n" + 
	    			"  },\r\n" + 
	    			"  \"accuracy\": 50,\r\n" + 
	    			"  \"name\": \"Sivaji group of industries\",\r\n" + 
	    			"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
	    			"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
	    			"  \"types\": [\r\n" + 
	    			"    \"shoe park\",\r\n" + 
	    			"    \"shop\"\r\n" + 
	    			"  ],\r\n" + 
	    			"  \"website\": \"http://google.com\",\r\n" + 
	    			"  \"language\": \"French-IN\"\r\n" + 
	    			"}");
	        
	    }

	    @When("^User submit the request type of api$")
	    public void user_submit_the_request_type_of_api() throws Throwable {
	    	when().post("maps/api/place/add/json?key= qaclick123").then().log()
	    	.all().assertThat().statusCode(200);
	       
	    }
       @Then("^User validate the wheather it should show exact result or not$")
	    public void user_validate_the_wheather_it_should_show_exact_result_or_not() throws Throwable {
	      System.out.println("Testing purpose we entered");
	       
	    }

}
