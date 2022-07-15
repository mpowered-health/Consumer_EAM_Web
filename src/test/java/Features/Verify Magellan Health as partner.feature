Feature: Verify Magellan Health as a partner

  Background:
    Given  Open browser and login
    When Navigate to  circle page


  Scenario: Verify and Add Magellan Health as partner
    And Add Magellan Health as a partner
    And Accept terms and conditions for Magellan Health
    And Verify Magellan Health is added as a partner
    And Browser  close