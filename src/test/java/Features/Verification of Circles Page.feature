Feature: Verification of Circles Page

  Background:
    Given MPH URL open in a browser
      When Login using valid username and password
      Then Navigate to circles page

    Scenario: Verify Circles Page when no partner is selected
      And Verify the circles page UI
      * browser close


#      Scenario: Verify Circles add partners listed
#        And Click on add a partner button
#        And Add a partner
#        And Verify the partner is added
#        And browser close



