Feature: Verify VA as a partner

  Background:
    Given  Open the browser
    When Login to the MPH web
    Then Navigate circle page

  Scenario: Verify and Add VA as partner
    And Add VA as a partner
    And Send OTP and click continue for VA
    And Verify VA is added as a partner
    And Browser  is closed