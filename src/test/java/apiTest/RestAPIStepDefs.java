package apiTest;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIStepDefs {

	RequestSpecification request;
	Response response;

	@Given("I have the endpoint as {string}")
	public void i_have_the_endpoint_as(String endpointURL) {
		// Write code here that turns the phrase above into concrete actions
		request = RestAssured.given().baseUri(endpointURL);
	}

	@When("I perform the GET operation")
	public void i_perform_the_GET_operation() {
		// Write code here that turns the phrase above into concrete actions
		response = request.get();
	}

	@Then("I get the response code as {int}")
	public void i_get_the_response_as(int expectedResponse) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(expectedResponse, response.getStatusCode());
		;
	}

	@When("I perform the POST operation with below data")
	public void i_perform_the_Post_operation_with_below_data(Map<String, String> datamap) {

		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datamap).post();

		System.out.println("The response is " + response.getBody().asString());

	}

}
