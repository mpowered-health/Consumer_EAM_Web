Feature: Verify Humana as partner

  Background:
    Given Browser with MPH application open

  Scenario: Add Humana as partner
    When Added Humana as partner
    Then Verify Humana is added as a partner
    And Close the browser