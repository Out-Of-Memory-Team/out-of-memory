Feature: Manage Flashcard
    User should be able to manage his flashcard using "Manage Flashcard"

    Scenario: Create new flashcard with required information
    Given I expect the user to enter a front, a back and the deck for the new flashcard
    When The 'Save'-Button was clicked
    Then The Tooltip "Successfully added new flashcard to deck is displayed

    Scenario: Create new flashcard without required information
    Given I do not expect any input from the user
    When The 'Save'-Button was clicked
    Then The Tooltip "Failed to add new flashcard to deck is displayed

    Scenario: Edit a flashcard
    Given The user created at least one flashcard
    And A flashcard is selected 
    When Clicked on 'Edit'-Icon
    Then The 'Create'-Page is shown with all information that can be edited

    Scenario: show Flashcard
    Given I expect the user taps on "Manage Flashcard"
    Then I get a list of own flashcards
    And the list will be visualized

    Scenario: User Taps on "Delete"
    Given A flashcard is selected 
    And I expect the user taps on "Delete"
    Then show a modal asking
    Then delete flashcard
    Then the list is updated
    Then show flashcard
    
    Scenario: View flashcard in deck
    Given I expect the user select a deck
    Then i get a list of cards from the selected deck
    And the list will be visualized

    Scenario: Move flashcard to specific deck
    Given I expext the user select a flashcard 
    And I expect the user taps on "Edit"
    And I expect the user taps on "Select deck"
    And I expect the user chooses a deck
    And I expect the user taps on "Save"
    Then the flashcard is deleted from the current deck
    Then the flashcard is added to the selected deck
    Then show flashcard

    