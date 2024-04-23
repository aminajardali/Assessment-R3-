Feature: Currency conversion rate accuracy

  Scenario: Fetch USD price against AED and check range
    Given the API is available
    When I fetch the conversion rate for USD to AED
    Then the conversion rate should be between 3.6 and 3.7