Feature: Test the YouTube search functionality

  Scenario: The user should be able to navigate to YouTube and search a video
    Given the user navigates to youtube successfully
    When the user searches a video
    Then the video search results appear successfully