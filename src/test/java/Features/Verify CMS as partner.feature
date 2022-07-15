Feature: Verify CMS as a partner

  Background:
    Given MPH open in a browser
    When Login valid username and password
    Then Navigate circles page

    Scenario: Verify and Add CMS as partner
      And Add CMS as a partner
      And Accept terms and conditions
      And Verify CMS is added as a partner
      And Browser is closed

