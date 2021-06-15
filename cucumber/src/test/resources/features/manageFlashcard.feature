Feature: Manage Flashcard
    As an User
    I should be able to manage flashcards using "Manage Flashcard"

    Scenario: Create new flashcard with required information
        Given I expect the user is logged in1
        And   is on the decks page1
        And   I expect the user to have at least one deck created create flashcard
        And the user is on the specific Deck create
        When User clicks on Add Flashcard button
        And  the user to enter a front, a back and the deck for the new flashcard
        And  clicks on save button
        Then  User is navigated to the specific deck page and the card ist shown in the list

    Scenario: Show Flashcard
        Given I expect the user is logged in1
        And is on the decks page1
        And I expect the user to have at least one deck created view flashcard
        And the user is on the specific Deck view
        And The user created at least one flashcard
        Then I get a list of own flashcards

    Scenario: Edit a flashcard
        Given I expect the user is logged in1
        And is on the decks page1
        And I expect the user to have at least one deck created edit flashcard
        And the user is on the specific Deck edit
        And The user created at least one flashcard edit
        When user Clicked on edit Icon on flashcard
        And User can edit front, back
        And clicks on save button
        Then User is navigated back to Flashcard List page

    Scenario: Delete Flashcard
        Given I expect the user is logged in1
        And is on the decks page1
        And I expect the user to have at least one deck created delete flashcard
        And the user is on the specific Deck delete
        And The user created at least one flashcard delete
        When user Clicked on delete Icon on flashcard
        And user clicks on delete on the modal
        Then Flashcard is deleted

    