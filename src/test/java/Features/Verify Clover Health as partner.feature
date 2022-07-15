Feature: Verify Clover Health as a partner

  Background:
    Given  Open browser and access MPH
    When Login  MPH
    Then Navigate to circle page

  Scenario: Verify and Add Clover Health as partner
    And Add Clover Health as a partner
    And Accept terms and conditions for Clover Health
    And Verify Clover Health is added as a partner
    And Browser Close