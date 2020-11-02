Feature: Manage Flashcard
    As an User
    I should be able to manage flashcards using "Manage Flashcard"

    Scenario: Create new flashcard with required information
    Given I expect the user to enter a front, a back and the deck for the new flashcard
    When The 'Save'-Button was clicked
    Then The Tooltip "Successfully added new flashcard to deck" is displayed

    Scenario: Create new flashcard without required information
    Given I do not expect any input from the user
    When The 'Save'-Button was clicked
    Then The Tooltip "Failed to add new flashcard to deck" is displayed

    Scenario: Edit a flashcard
    Given The user created at least one flashcard
    And A flashcard is selected 
    When Clicked on 'Edit'-Icon
    Then The 'Create'-Page is shown with all information that can be edited

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

    