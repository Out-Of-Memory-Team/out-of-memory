package stepDefinitions;

import Wrapper.seleniumWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ManageFlashcardSteps {
    seleniumWrapper wrapper = new seleniumWrapper();
    String testDeckCreateFlashcards = "Test Deck create Flashcard";
    String testDeckCreateFlash = "Test Deck create Flash"; //zur Auswahl des Decks da in das Input feld der ganze Name nicht reinpasst
    String testCreateFlashcardFront = "Front create";
    String testCreateFlashcardBack = "Back create";

    String testDeckEditFlashcards = "Test Deck edit Flashcard";
    String testDeckEditFlash = "Test Deck edit Flash";
    String testEditFlashcardFront = "Front edit";
    String testEditFlashcardBack = "Back edit";

    String testDeckViewFlashcards ="Test Deck view Flashcard";
    String testDeckViewFlash = "Test Deck view Flash";
    String testViewFlashcardFront = "Front view";
    String testViewFlashcardBack = "Back view";

    String testDeckDeleteFlashcards ="Test Deck delete Flashcard";
    String testDeckDeleteFlash = "Test Deck delete Flash";
    String testDeleteFlashcardFront = "Front delete";
    String testDeleteFlashcardBack = "Back delete";


    @Given("I expect the user is logged in1")
    public void i_expect_the_user_is_logged_in1() {
        System.out.println("inside step - I expect the user is logged in1");
        String username = "TestUser1234";
        String password = "TestUser1.";
        System.out.println("inside step - user is on login page");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projet path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        wrapper.setDriver();
        wrapper.setTimeout();
        wrapper.navigateTo("http://localhost:4200/ ");
        wrapper.findWebSpanWithText("Log-In").click();
        wrapper.findWebElementWithPlaceholderText("Username").sendKeys(username);
        wrapper.findWebElementWithPlaceholderText("Password").sendKeys(password);
        wrapper.findWebButtonWithText("Submit").click();
    }
    @And("is on the decks page1")
    public void is_on_the_decks_page1() throws InterruptedException {
        System.out.println("inside step - is on the decks page1");
        Thread.sleep(2000);
        wrapper.findWebSpanWithText("Decks").click();
    }
    @And("I expect the user to have at least one deck created create flashcard")
    public void i_expect_the_user_to_have_at_least_one_deck_created_create_flashcard(){
        System.out.println("inside step - And I expect the user to have at least one deck created");
        createDeck(testDeckCreateFlashcards);
    }
    @And("the user is on the specific Deck create")
    public void the_user_is_on_the_specific_Deck_create(){
        System.out.println("inside step - the user is on the specific Deck create");
        clickOnDeck(testDeckCreateFlashcards);
    }
    @When("User clicks on Add Flashcard button")
    public void user_clicks_on_Add_Flashcard_button(){
        System.out.println("inside step - User clicks on Add Flashcard button");
        wrapper.scrollToBottom();
        wrapper.findWebButtonWithText("Add Flashcard").click();
    }

    @And("the user to enter a front, a back and the deck for the new flashcard")
    public void the_user_to_enter_a_front_a_back_and_the_deck_for_the_new_flashcard() throws InterruptedException {
        System.out.println("inside step - the user to enter a front, a back and the deck for the new flashcard");
        wrapper.writeFrontAndBack("Insert text here ...",testCreateFlashcardFront,testCreateFlashcardBack);
        wrapper.scrollToBottom();
        wrapper.findInput().sendKeys(testDeckCreateFlash);
        wrapper.findClrOptionWithText(testDeckCreateFlashcards).click();
    }
    @And("clicks on save button")
    public void clicks_on_save_button(){
        System.out.println("inside step - clicks on save button");
        wrapper.findWebButtonWithText("Save").click();
    }
    @Then("User is navigated to the specific deck page and the card ist shown in the list")
    public void user_is_navigated_to_the_specific_deck_page_and_the_card_ist_shown_in_the_list() throws InterruptedException {
        System.out.println("inside step - User is navigated to the specific deck page and the card ist shown in the list");
        Assert.assertNotNull(wrapper.findWebDivWithText("Card saved."));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created edit flashcard")
    public void i_expect_the_user_to_have_at_least_one_deck_created_edit_flashcard(){
        System.out.println("inside step - I expect the user to have at least one deck created edit flashcard");
        createDeck(testDeckEditFlashcards);
    }
    @And("the user is on the specific Deck edit")
    public void the_user_is_on_the_specific_Deck_edit(){
        System.out.println("inside step - the user is on the specific Deck edit");
        clickOnDeck(testDeckEditFlashcards);
    }
    @And("The user created at least one flashcard edit")
    public void the_user_created_at_least_one_flashcard_edit(){
        System.out.println("inside step - The user created at least one flashcard");
        createFlashcard(testDeckEditFlashcards,testDeckEditFlash,testEditFlashcardFront,testEditFlashcardBack);
    }
    @When("user Clicked on edit Icon on flashcard")
    public void user_Clicked_on_edit_icon_on_flashcard() throws InterruptedException {
        System.out.println("inside step - user Clicked on edit Icon on flashcard");
        Thread.sleep(6000);
        wrapper.findWebIconWithShapeAfterDivWithClass("action-bar card no-margin","pencil").click();
    }
    @And("User can edit front, back")
    public void user_can_edit_front_back(){
        System.out.println("inside step - User can edit front, back");
        wrapper.writeFrontAndBack("Insert text here ..."," (edited)", "(edited)");
    }
    @Then("User is navigated back to Flashcard List page")
    public void user_is_navigated_back_to_Flashcard_List_page(){
        System.out.println("inside step - User is navigated back to Flashcard List page");
        Assert.assertNotNull(wrapper.findWebDivWithText("Card saved."));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created view flashcard")
    public void i_expect_the_user_to_have_at_least_one_deck_created_view_flashcard(){
        System.out.println("inside step - I expect the user to have at least one deck created view flashcard");
        createDeck(testDeckViewFlashcards);
    }
    @And("the user is on the specific Deck view")
    public void the_user_is_on_the_specific_Deck_view(){
        System.out.println("inside step - the user is on the specific Deck view");
        clickOnDeck(testDeckViewFlashcards);
    }
    @And("The user created at least one flashcard")
    public void the_user_created_at_least_one_flashcard(){
        System.out.println("inside step - The user created at least one flashcard");
        createFlashcard(testDeckViewFlashcards,testDeckViewFlash,testViewFlashcardFront,testViewFlashcardBack);
    }
    @Then("I get a list of own flashcards")
    public void i_get_a_list_of_own_flashcards(){
        System.out.println("inside step - I get a list of own flashcards");
        Assert.assertNotNull(wrapper.findWebElementWithText(testViewFlashcardFront));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created delete flashcard")
    public void i_expect_the_user_to_have_at_least_one_deck_created_delete_flashcard(){
        System.out.println("inside step - I expect the user to have at least one deck created delete flashcard");
        createDeck(testDeckDeleteFlashcards);
    }
    @And("the user is on the specific Deck delete")
    public void the_user_is_on_the_specific_Deck_delete(){
        System.out.println("inside step - the user is on the specific Deck delete");
        clickOnDeck(testDeckDeleteFlashcards);
    }
    @And("The user created at least one flashcard delete")
    public void the_user_created_at_least_one_flashcard_delete(){
        System.out.println("inside step - The user created at least one flashcard delete");
        createFlashcard(testDeckDeleteFlashcards,testDeckDeleteFlash,testDeleteFlashcardFront,testDeleteFlashcardBack);
    }
    @When("user Clicked on delete Icon on flashcard")
    public void userClicked_on_delete_Icon_on_flashcard() throws InterruptedException {
        System.out.println("inside step - user Clicked on delete Icon on flashcard");
        Thread.sleep(6000);
        wrapper.findWebIconWithShapeAfterDivWithClass("action-bar card no-margin","trash").click();
    }
    @And("user clicks on delete on the modal")
    public void user_clicks_on_delete_on_the_modal(){
        System.out.println("inside step - user clicks on delete on the modal");
        wrapper.findWebButtonWithText("Delete").click();
    }
    @Then("Flashcard is deleted")
    public void flashcard_is_deleted(){
        System.out.println("inside step - Flashcard is deleted");
        Assert.assertNotNull(wrapper.findWebDivWithText("Flashcard deleted"));
        wrapper.closeBrowser();
    }
    public void createDeck(String deckTitle){
        wrapper.findWebButtonWithText("Add Deck").click();
        wrapper.findWebElementWithPlaceholderText("Enter title...").sendKeys(deckTitle);
        wrapper.findWebElementWithPlaceholderText("Enter description...").sendKeys("This is a test deck for selenium tests");
        wrapper.scrollToBottom();
        wrapper.findWebButtonWithText("Save").click();
    }
    public void createFlashcard(String deckName,String deckNameForInput, String frontSite, String backSite){
        wrapper.scrollToBottom();
        wrapper.findWebButtonWithText("Add Flashcard").click();
        wrapper.writeFrontAndBack("Insert text here ...",frontSite,backSite);
        wrapper.scrollToBottom();
        wrapper.findInput().sendKeys(deckNameForInput);
        wrapper.findClrOptionWithText(deckName).click();
        wrapper.findWebButtonWithText("Save").click();
    }
    public void clickOnDeck(String deckTitle){
        wrapper.findWebCellWithText(deckTitle).click();
    }

}
