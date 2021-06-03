package stepDefinitions;

import Wrapper.seleniumWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    seleniumWrapper wrapper = new seleniumWrapper();
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("inside step - user is on login page");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projet path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        wrapper.setDriver();
        wrapper.setTimeout();
        wrapper.navigateTo("http://localhost:4200/ ");
        wrapper.findWebButtonWithText("Start Now").click();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("inside step - user enters username and password");
        wrapper.findWebElementWithPlaceholderText("Username").sendKeys("testUser");
        wrapper.findWebElementWithPlaceholderText("Password").sendKeys("testpassword");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("inside step - user clicks on login button");
        wrapper.findWebButtonWithText("Submit");
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws Exception {
        System.out.println("inside step - user is navigated to the homepage");

        if (wrapper.findWebElementWithText("User") != null){
            System.out.println("Test passed");
        }
        else{
            throw new Exception();
        }
    }
}
