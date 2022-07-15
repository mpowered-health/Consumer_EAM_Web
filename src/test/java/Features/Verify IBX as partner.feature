Feature: Verify IBX as a partner

  Background:
    Given Open browser with appropriate browser
    When Login  MPH web
    Then Navigate to  circles

  Scenario: Verify and Add IBX as partner
    And Add IBX as a partner
    And Verify IBX is added as a partner
    And Browser  closed