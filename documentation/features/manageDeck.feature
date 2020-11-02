Feature: Manage Deck
  As an user
  I should be able to create, edit or delete decks and list all of the created decks.

  Scenario: Create new deck with required information
    Given I expect the user to enter a title, a description and tags for the new deck
    When The 'Save'-Button was clicked
    Then The Tooltip "Successfully added new flashcard to deck is displayed

  Scenario: Create new deck without required information
    Given I do not expect any input from the user
    When The 'Save'-Button was clicked
    Then The Tooltip "Failed to add new flashcard to deck is displayed

  Scenario: View a specific deck
    Given I expect the user to have at least one deck created
    When Clicked on a specific deck
    Then The 'View'-Page is shown to the user with all relevant information about the deck

  Scenario: Edit a deck
    Given I expect the user to have at least one deck created
    And I except the user to view a specific deck
    When Clicked on 'Edit'-Icon
    Then The 'Create'-Page is shown with all information that can be edited

  Scenario: List a deck
    Given I expect the user to have at least one deck created
    When Clicked on 'Decks'-Tab at navigation bar
    Then The 'Your Decks'-Page is shown with a list of all created decks

  Scenario: Try to delete a deck
    Given I expect the user to have at least one deck created
    And I expect the user to view or edit a specific deck
    When Clicked on 'Delete'-Icon
    Then The 'Delete Deck'-Dialog is shown

  Scenario: Delete a deck
    Given I expect the user to have at least one deck created
    And I expect the user to view or edit a specific deck
    And I expect the user to have clicked on the 'Delete'-Icon
    When Clicked on 'Delete'-Button
    Then The 'Delete Deck'-Dialog should disappear and the should be deleted
