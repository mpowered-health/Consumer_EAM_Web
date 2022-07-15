Feature: Verify Scan Health as a partner

  Background:
    Given Open browser with  appropriate browser
    When Login MPH to web
    Then Navigate to  circle

  Scenario: Verify and Add Scan Health as partner
    And Add Scan Health as a partner
    And Verify Scan Health is added as a partner
    And Close  the browser