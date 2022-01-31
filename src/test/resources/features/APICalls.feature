@API
Feature:
  As a QA engineer I should be able to call API's (send requests, receive responses and assert results)

  Scenario: As a user I should be able to verify API calls (Get request)
    Given Swagger documentation
    Then user can verify API get request