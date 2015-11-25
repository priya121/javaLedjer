Feature: Exercise 2
  The ledger can accept payments.
  Payments decrease the balance of the ledger.

  Scenario: Payments.
    Given an empty ledger
    And a deposit of 10000p is made
    When a payment of 100p is made to Apple
    And a payment of 200p is made to Amazon
    And a payment of 300p is made to BBC
    Then the balance is 9400p
    And the statement contains
    """
    Deposit: £100.00
    Payment to Apple: (£1.00)
    Payment to Amazon: (£2.00)
    Payment to BBC: (£3.00)
    Total: £94.00
    """
