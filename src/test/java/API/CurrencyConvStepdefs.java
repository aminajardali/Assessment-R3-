package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import static org.junit.Assert.*;

public class CurrencyConvStepdefs {
    private OkHttpClient client = new OkHttpClient();
    private Response response;
    private JsonObject jsonResponse;
    private Gson gson = new Gson();

    @Given("the API is available")
    public void theAPIIsAvailable() {
        // Assume API is available, might normally check a health check endpoint
    }

    @When("I fetch the conversion rate for USD to AED")
    public void iFetchTheConversionRateForUSDToAED() throws Exception {
        Request request = new Request.Builder()
                .url("https://open.er-api.com/v6/latest/USD") // Replace with your actual URL
                .build();
        response = client.newCall(request).execute();
        jsonResponse = gson.fromJson(response.body().string(), JsonObject.class);
    }

    @Then("the conversion rate should be between {double} and {double}")
    public void theConversionRateShouldBeBetweenAnd(double lowerBound, double upperBound) {
        JsonObject rates = jsonResponse.getAsJsonObject("rates");
        double conversionRate = rates.get("AED").getAsDouble();
        assertTrue("Conversion rate is not within the specified range",
                conversionRate >= lowerBound && conversionRate <= upperBound);
    }
}
