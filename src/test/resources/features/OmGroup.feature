@UI
Feature: OmGroupInc_app

  As an QA engineer I should automate several functions in an app

  Scenario: app's automation

    Given user is on a main page of the app_OmGroupInc
    When user clicks on About Us button
    Then user should be able to redirect to the page with additional info
    And user should be able to perform CssValue verification for fontSize_color_fontWeight