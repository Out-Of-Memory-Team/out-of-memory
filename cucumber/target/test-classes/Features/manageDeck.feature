Feature: Manage Deck
  As an user
  I should be able to create, edit or delete decks and list all of the created decks.

  Scenario: Create new deck with required information
    Given I expect the user is logged in
    And is on the decks page
    When the user clicks on add deck
    And enters title and description
    And clicks on save
    Then the view page for the created decks is shown

  Scenario: Create new deck without required information
    Given I expect the user is logged in
    And is on the decks page
    When the user clicks on add deck
    And clicks on save
    Then A error notification is shown

  Scenario: View a specific deck
    Given I expect the user is logged in
    And is on the decks page
    And I expect the user to have at least one deck created View
    When Clicked on a specific deck View
    Then The view page is shown to the user with all relevant information about the deck

  Scenario: Edit a deck
    Given I expect the user is logged in
    And is on the decks page
    And I expect the user to have at least one deck created Edit
    And I except the user to view a specific deck
    When Clicked on edit Icon
    And Changed the title
    And clicks on save
    Then The create page is shown with all information that can be edited

  Scenario: Try to delete a deck
    Given I expect the user is logged in
    And is on the decks page
    And I expect the user to have at least one deck created Delete
    When Clicked on specific deck delete
    And the user clicks on delete icon
    And  clicks on the delete button
    Then this deck should be deleted
