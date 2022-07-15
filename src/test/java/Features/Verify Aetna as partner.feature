Feature: Verify Aetna as a partner

  Background:
    Given Initiate browser
    When Login  to MPH web
    Then Navigate to  the circles

  Scenario: Verify and Add Aetna as partner
    And Add Aetna as a partner
    And Verify Aetna is added as a partner
    And Browser   is closed