Feature: Validate API response and structure

  Scenario: API call is successful and returns a valid price
    Given the API is available
    When I request the current price
    Then the API call should be successful
    And the response should include a valid price

  Scenario: API response status code and status check
    Given the API is available
    When I request the current price
    Then the API response should return a status code of 200
    And the API response status should be "success"

  Scenario: Validate API response JSON schema
    Given the API is available
    When I request the current price
    Then the API response should match the defined JSON schema
