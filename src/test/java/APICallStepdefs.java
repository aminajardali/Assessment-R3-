import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("the API is available")
    public void theAPIIsAvailable() {
    }

    @When("I request the current price")
    public void iRequestTheCurrentPrice() {
    }

    @Then("the API call should be successful")
    public void theAPICallShouldBeSuccessful() {
    }

    @And("the response should include a valid price")
    public void theResponseShouldIncludeAValidPrice() {
    }

    @Then("the API response should return a status code of {int}")
    public void theAPIResponseShouldReturnAStatusCodeOf(int arg0) {
    }

    @And("the API response status should be {string}")
    public void theAPIResponseStatusShouldBe(String arg0) {
    }

    @Then("the API response should match the defined JSON schema")
    public void theAPIResponseShouldMatchTheDefinedJSONSchema() {
    }
}
