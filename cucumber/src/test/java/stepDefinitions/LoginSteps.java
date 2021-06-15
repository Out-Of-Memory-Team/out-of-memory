package stepDefinitions;

import Wrapper.seleniumWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    seleniumWrapper wrapper = new seleniumWrapper();
    String username = "TestUser1234";
    String password = "TestUser1.";

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("inside step - user is on login page");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projet path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        wrapper.setDriver();
        wrapper.setTimeout();
        wrapper.navigateTo("http://localhost:4200/ ");
        wrapper.findWebSpanWithText("Log-In").click();
    }
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password(){
        System.out.println("inside step - user enters invalid username and password");
        wrapper.findWebElementWithPlaceholderText("Username").sendKeys("Peterlustig8811");
        wrapper.findWebElementWithPlaceholderText("Password").sendKeys("peter98");
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("inside step - user enters username and password");
        wrapper.findWebElementWithPlaceholderText("Username").sendKeys(username);
        wrapper.findWebElementWithPlaceholderText("Password").sendKeys(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("inside step - user clicks on login button");
        wrapper.findWebButtonWithText("Submit").click();
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws Exception {
        System.out.println("inside step - user is navigated to the homepage");
    Assert.assertNotNull(wrapper.findWebButtonWithText(username));
        wrapper.closeBrowser();
    }
    @Then("user gets an error")
    public void user_gets_an_error() throws Exception {
        System.out.println("inside step - user gets an error");
        Assert.assertNotNull(wrapper.findWebDivWithText("Invalid user name or password"));
        wrapper.closeBrowser();
    }
}
