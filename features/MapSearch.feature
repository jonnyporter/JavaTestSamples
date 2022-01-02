Feature: Test the Google Maps search functionality

  Scenario: The user should be able to navigate to Maps from HomePage and search a city
    Given the user goes to home page
    And the user navigates to maps successfully
    When the user searches a city name
    Then the city search results appear successfully


