Feature: Validate number of currency pairs returned

  Scenario: Verify the number of currency pairs
    Given the API is available
    When I request the list of all currency pairs
    Then the API should return exactly 162 currency pairs