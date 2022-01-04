#Description : Google Search
Feature: Feature to validate googlea search functionallity

  Scenario: Validate google search is working
    Given User is on Google search page
    When User enters a text in search box
    And User doesnt check checking Privacy Policy box
    And Hits enter
    Then User is navigated to search results
