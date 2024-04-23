Feature: API response time validation

  Scenario: Verify API response time
    Given the API is available
    When I request any data
    Then the response time should not be more than 3 seconds from the request time