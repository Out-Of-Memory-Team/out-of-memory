Feature: Manage Flashcard
    As an User
    I should be able to manage flashcards using "Manage Flashcard"

    Scenario: Create new flashcard with required information
    Given User is on the create Flashcard-page
    When  the user to enter a front, a back and the deck for the new flashcard
    When  User clicks on save-Button
    Then  User is navigated to FlashcardList-page

    Scenario: Edit a flashcard
    Given User is on the FlashcardList-page
    Given The user created at least one flashcard
    When User select a flashcard
    When Clicked on 'Edit'-Icon
    When User can edit front, back and the deck
    Then User is navigated back to FlashcardList-page

    Scenario: Show Flashcard
    Given I expect the user taps on "Manage Flashcard"
    And I expect the user to have at least one flashcard created
    Then I get a list of own flashcards
    And the list will be visualized

    Scenario: Delete Flashcard
    Given A flashcard is selected
    And I expect the user to have at least one flashcard created
    And I expect the user clicks on "Delete"-Icon
    Then Show a modal asking
    Then Delete flashcard
    Then The list is updated
    Then Get back to 'Flashcard-List'-View of specific deck
    
    Scenario: View flashcard in deck
    Given I expect the user select a deck
    And I expect the user to have at least one deck created
    Then Get a list of cards from the selected deck
    And The list will be visualized

    Scenario: Move flashcard to specific deck
    Given I expect the user to select a flashcard
    And I expect the user clicks on "Edit"-Icon
    And I expect the user clicks on "Select deck"
    And I expect the user chooses a deck
    And I expect the user clicks on "Save"-Icon
    Then The flashcard is deleted from the current deck
    Then The flashcard is added to the selected deck
    Then Show flashcard

    