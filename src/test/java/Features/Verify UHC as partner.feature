Feature: Verify UHC as a partner

  Background:
    Given  Open browser
    When Login to MPH
    Then Navigate to the circle page

  Scenario: Verify and Add UHC as partner
    And Add UHC as a partner
    And Accept terms and conditions for UHC
    And Verify UHC is added as a partner
    And Browser is close