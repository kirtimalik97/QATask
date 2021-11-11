Feature: Store Tests

  Scenario Outline: Verify that user can place order for pet to store
    Given user puts Id as <Id>, petId as <PetId>, and quantity as <Quantity>
    Given user puts shipDate as "<ShipDate>", status "<Status>" and complete as "<Complete>"
    Then user place order for pet
    Then user validates the purchase details

    Examples:
      | Id | PetId | Quantity | ShipDate                | Status | Complete |
      | 32 | 211   | 2443     | 2021-11-11T15:48:10.845 | Placed | true     |

    @tc1
  Scenario Outline: Verify that user can delete the order placed for pet
    Given user puts Id as <Id>, petId as <PetId>, and quantity as <Quantity>
    Given user puts shipDate as "<ShipDate>", status "<Status>" and complete as "<Complete>"
    Then user place order for pet
    Then user delete the purchase

    Examples:
      | Id | PetId | Quantity | ShipDate                | Status | Complete |
      | 32 | 211   | 2443     | 2021-11-11T15:48:10.845 | Placed | true     |