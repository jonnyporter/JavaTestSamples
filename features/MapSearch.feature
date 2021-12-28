Feature: Test the Google Maps search functionality

  Scenario: The user should be able to navigate to Maps from HomePage and search a city
    Given user goes to home page
    And user navigates to maps successfully
    When user searches a city name
    Then city search results appear successfully

