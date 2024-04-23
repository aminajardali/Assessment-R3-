package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResponseTimeStepdefs {
    private OkHttpClient client = new OkHttpClient();
    private long requestTime;

    @When("I request any data")
    public void iRequestAnyData() throws IOException {
        // Make an API request and record the request time
        requestTime = System.currentTimeMillis();
        Request request = new Request.Builder()
                .url("https://open.er-api.com/v6/latest/USD") // Replace with your API endpoint
                .build();
        client.newCall(request).execute();
    }

    @Then("the response time should not be more than {int} seconds from the request time")
    public void theResponseTimeShouldNotBeMoreThanSecondsFromTheRequestTime(int seconds) {
        // Calculate the response time
        long responseTime = System.currentTimeMillis() - requestTime;
        // Compare the response time with the expected time
        assertTrue("Response time exceeds " + seconds + " seconds", responseTime <= seconds * 1000);
    }
}
