Feature: Verify BCBS as a partner

  Background:
    Given  Open a browser
    When Login to MPH with valid username and password
    Then Navigate to the circles page

  Scenario: Verify and Add BCBS as partner
    And Add BCBS as a partner
    And Accept terms and conditions for BCBS
    And Verify BCBS is added as a partner
    And Browser close