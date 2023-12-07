Feature: API Error Testing

  Scenario: Verify API Errors with 615 Request Failed
    When I make an API request with error request failed code and wrong city
    Then the response should contain the correct error details due to wrong city

  Scenario: Verify API Errors with 101 Invalid Access Key
    When I make an API request with invalid access key
    Then the response should contain the correct invalid access key error details

  Scenario: Verify API Errors with 105 HTTPS Access Restricted
    When I make an API request with HTTPS access restricted
    Then the response should contain the correct HTTPS access restricted error details

  Scenario: Verify API Errors with 103 API Function does not exist
    When I make an API request with error API function does not exist
    Then the response should contain the correct not found resource error details
