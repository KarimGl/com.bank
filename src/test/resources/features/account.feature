Feature: Bank Account

  Scenario: Deposit 50 euros and check balance
    Given I deposit 50 euros
    When I get the statement
    Then My balance should be 50

  Scenario: withdraw 50 and check balance
    Given I withdraw 50 euros
    When I get the statement
    Then My balance should be -50
