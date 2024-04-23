package API;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiCallStepDefs {
    private OkHttpClient client = new OkHttpClient();
    private Response response;
    private JsonObject jsonResponse;
    private Gson gson = new Gson();
    @When("I request the current price")
    public void iRequestTheCurrentPrice() throws Exception {
        Request request = new Request.Builder()
                .url("https://open.er-api.com/v6/latest/USD") // Replace with your actual URL
                .build();
        response = client.newCall(request).execute();
        jsonResponse = gson.fromJson(response.body().string(), JsonObject.class);
    }

    @Then("the API call should be successful")
    public void theAPICallShouldBeSuccessful() {
        assertEquals(200, response.code());
    }

    @And("the response should include a valid price")
    public void theResponseShouldIncludeAValidPrice() {
        assertTrue("Response JSON should have a 'rates' key", jsonResponse.has("rates"));
        JsonObject rates = jsonResponse.getAsJsonObject("rates");
        assertTrue("Rates should have a 'EUR' key", rates.has("EUR"));
        assertNotNull("EUR rate should not be null", rates.get("EUR").getAsString());
    }


    @Then("the API response should return a status code of {int}")
    public void theAPIResponseShouldReturnAStatusCodeOf(int arg0) {
        assertEquals(arg0, response.code());
    }

    @And("the API response status should be {string}")
    public void theAPIResponseStatusShouldBe(String expectedStatus) {
        assertTrue("Response JSON should have a 'result' key", jsonResponse.has("result"));
        assertNotNull("Result value should not be null", jsonResponse.get("result"));
        assertEquals("API response status should be '" + expectedStatus + "'", expectedStatus.toLowerCase(), jsonResponse.get("result").getAsString().toLowerCase());
    }
    @Then("the API response should match the defined JSON schema")
    public void theAPIResponseShouldMatchTheDefinedJSONSchema() {
        // Here you might use a JSON schema validator library to check the response
    }
}
