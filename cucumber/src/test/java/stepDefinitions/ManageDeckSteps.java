package stepDefinitions;

import Wrapper.seleniumWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ManageDeckSteps {
    seleniumWrapper wrapper = new seleniumWrapper();
    String testDeckCreate = "Test Create new Deck";
    String testDeckView = "Test View Deck";
    String testDeckEdit = "Test Edit Deck";
    String testDeckAfterEdit = "Test Edit Deck edited";
    String testDeckDelete = "Test Delete Deck";
    @Given("I expect the user is logged in")
    public void i_expect_the_user_is_logged_in() {
        System.out.println("inside step - I expect the user is logged in");
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
    @And("is on the decks page")
    public void is_on_the_decks_page() throws InterruptedException {
        System.out.println("inside step - is on the decks page");
        Thread.sleep(2000);
        wrapper.findWebSpanWithText("Decks").click();
    }
    @When("the user clicks on add deck")
    public void the_user_clicks_on_add_deck(){
        System.out.println("inside step - the user clicks on add deck");
        wrapper.findWebButtonWithText("Add Deck").click();
    }
    @And("enters title and description")
    public void enters_title_and_description(){
        System.out.println("inside step - enters title and description");
        wrapper.findWebElementWithPlaceholderText("Enter title...").sendKeys(testDeckCreate);
        wrapper.findWebElementWithPlaceholderText("Enter description...").sendKeys("This is a test deck for selenium tests");
    }
    @And("clicks on save")
    public void clicks_on_save(){
        System.out.println("inside step - clicks on save");
        wrapper.scrollToBottom();
        wrapper.findWebButtonWithText("Save").click();
    }
    @Then("the view page for the created decks is shown")
    public void the_view_page_for_the_created_decks_is_shown() throws Exception {
        System.out.println("inside step - the view page for the created decks is shown");
        Assert.assertNotNull(wrapper.findWebElementWithText(testDeckCreate));
        wrapper.closeBrowser();
    }
    @Then("A error notification is shown")
    public void a_error_notification_is_shown() throws Exception {
        System.out.println("inside step - A error notification is shown");
        Assert.assertNotNull(wrapper.findWebDivWithText("Failed!"));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created View")
    public void i_expect_the_user_to_have_at_least_one_deck_created_View(){
        System.out.println("inside step - I expect the user to have at least one deck created View");
        createDeck(testDeckView);
    }
    @When("Clicked on a specific deck View")
    public void clicked_on_a_specific_deck_View(){
        System.out.println("inside step - Clicked on a specific deck");
        wrapper.findWebCellWithText(testDeckView).click();

    }
    @Then("The view page is shown to the user with all relevant information about the deck")
    public void the_view_page_is_shown_to_the_user_with_all_relevant_information_about_the_deck() throws Exception {
        System.out.println("inside step - The view page is shown to the user with all relevant information about the deck");
        Assert.assertNotNull(wrapper.findWebSpanWithText("Collaborators"));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created Edit")
    public void i_expect_the_user_to_have_at_least_one_deck_created_Edit(){
        System.out.println("inside step - I expect the user to have at least one deck created Edit");
        createDeck(testDeckEdit);
    }
    @And("I except the user to view a specific deck")
    public void i_except_the_user_to_view_a_specific_deck(){
        System.out.println("inside step - I except the user to view a specific deck");
        wrapper.findWebCellWithText(testDeckEdit).click();
    }
    @When("Clicked on edit Icon")
    public void clicked_on_edit_Icon(){
        System.out.println("inside step - Clicked on edit Icon");
        wrapper.findWebIconWithShape("pencil").click();
    }
    @And("Changed the title")
    public void changed_the_title(){
        System.out.println("inside step - Changed the title");
        wrapper.findWebElementWithPlaceholderText("Enter title...").clear();
        wrapper.findWebElementWithPlaceholderText("Enter title...").sendKeys(testDeckAfterEdit);
    }
    @Then("The create page is shown with all information that can be edited")
    public void the_create_page_is_shown_with_all_information_that_can_be_edited() throws Exception {
        System.out.println("inside step - The create page is shown with all information that can be edited");
        Assert.assertNotNull(wrapper.findWebElementWithText(testDeckAfterEdit));
        wrapper.closeBrowser();
    }
    @And("I expect the user to have at least one deck created Delete")
    public void i_expect_the_user_to_have_at_least_one_deck_created_Delete(){
        System.out.println("inside step - I expect the user to have at least one deck created Delete");
        createDeck(testDeckDelete);
    }
    @When("Clicked on specific deck delete")
    public void clicked_on_specific_deck_delete(){
        System.out.println("inside step - Clicked on specific deck delete");
        wrapper.findWebCellWithText(testDeckDelete).click();
    }
    @And("the user clicks on delete icon")
    public void the_user_clicks_on_delete_icon(){
        System.out.println("inside step - the user clicks on delete icon");
        wrapper.findWebIconWithShape("trash").click();
    }
    @And("clicks on the delete button")
    public void clicks_on_the_delete_button(){
        System.out.println("inside step - clicks on the delete button");
        wrapper.findWebButtonWithText("Delete").click();
    }
    @Then("this deck should be deleted")
    public void this_deck_should_be_deleted() throws Exception {
        System.out.println("inside step - this deck should be deleted");
        Assert.assertNotNull(wrapper.findWebDivWithText("Deck deleted."));
        wrapper.closeBrowser();
    }

    public void createDeck(String title){
        wrapper.findWebButtonWithText("Add Deck").click();
        wrapper.findWebElementWithPlaceholderText("Enter title...").sendKeys(title);
        wrapper.findWebElementWithPlaceholderText("Enter description...").sendKeys("This is a test deck for selenium tests");
        wrapper.findWebButtonWithText("Save").click();
    }
}
