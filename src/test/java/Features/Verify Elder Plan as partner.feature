Feature: Verify Elder plan as a partner

  Background:
    Given Open browser with appropriate browser
    When Login MPH web
    Then Navigate to circles

  Scenario: Verify and Add Elder plan as partner
    And Add Elder plan as a partner
    And Authorise Elder plan
    And Verify Elder plan is added as a partner
    And Browser closed