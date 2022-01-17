Feature: Movie demo site

  As an QA engineer I should automate several functions in an app

  @demo
  Scenario: search box verification

    Given user is on a main page of the app
    When user clicks on a search box and user provides specific movie's name_title
    And user clicks to the search button
    Then user should be able to see movie's title that he_she was searching for