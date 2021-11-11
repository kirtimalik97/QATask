Feature: Pet Tests

  Scenario Outline: Verify that user can add pet to store inventory
    Given user puts id as <Id>, name as "<Name>", and status as "<Status>" about pet
    Given user puts category details id as <CategoryId> and name as "<CategoryName>"
    Given user puts photo url as "<PhotoUrls>"
    Given user puts tags details, id as <TagsId> and name as "<TagsName>"
    Then user adds pet to inventory
    Then user validates pet details

    Examples:
      | Id      | Name  | Status    | CategoryId | CategoryName | PhotoUrls                 | TagsId | TagsName  |
      | 5829131 | Lizzi | Available | 43         | Doggo        | www.petdata.com/Lizzi.jpg | 6      | Labradore |
    #  | 2311 | Snow  | Available | 6772       | Cat          | www.petdata.com/Snow.jpg  | 98     | Parsian   |


  Scenario Outline: Verify that user can update pet in store inventory
    Given user puts id as <Id>, name as "<Name>", and status as "<Status>" about pet
    Given user puts category details id as <CategoryId> and name as "<CategoryName>"
    Given user puts photo url as "<PhotoUrls>"
    Given user puts tags details, id as <TagsId> and name as "<TagsName>"
    Then user adds pet to inventory
    Then user validates pet details
    When user update pet details, name as "<UpdatedName>" and status as "<UpdatedStatus>"
    Then user validates pet details
    Then user delete pet from inventory

    Examples:
      | Id      | Name   | Status    | CategoryId | CategoryName | PhotoUrls                  | TagsId | TagsName  | UpdatedName | UpdatedStatus |
      | 2334611 | Snuffy | Available | 43         | Doggo        | www.petdata.com/Snuffy.jpg | 6      | Labradore | kiwi        | Not Available |
     # | 4333232 | Meow   | Available | 32         | Cat          | www.petdata.com/Meow.jpg   | 643    | Parsian   | billi       | Not Available |

  Scenario Outline: Verify that user can delete pet from store inventory
    Given user puts id as <Id>, name as "<Name>", and status as "<Status>" about pet
    Given user puts category details id as <CategoryId> and name as "<CategoryName>"
    Given user puts photo url as "<PhotoUrls>"
    Given user puts tags details, id as <TagsId> and name as "<TagsName>"
    Then user adds pet to inventory
    Then user validates pet details
    Then user delete pet from inventory

    Examples:
      | Id     | Name | Status    | CategoryId | CategoryName | PhotoUrls               | TagsId | TagsName  |
      | 632135 | Pot  | Available | 1631       | Doggo        | www.petdata.com/Pot.jpg | 6      | Labradore |
   #   | 57265971456 | Panda | Available | 5444       | Cat          | www.petdata.com/Panda.jpg | 6      | Parsian   |


