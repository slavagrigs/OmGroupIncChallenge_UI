@AccessibilityTest
Feature: As a QA Engineer I should be able to run accessibility testing (508) with AXE core tool

  Scenario: Check accessibility for the www.omgroupinc.us
    Given User is on the www.omgroupinc.us page
    Then Using Axe core tool user should be able to run accessibility testing and get the report