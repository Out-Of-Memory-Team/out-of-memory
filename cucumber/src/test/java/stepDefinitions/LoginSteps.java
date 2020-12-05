package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginSteps {
    WebDriver driver = null;
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("inside step - user is on login page");

        String projectPath = System.getProperty("user.dir");
        System.out.println("projet path is: " + projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.navigate().to("http://localhost:4200/ ");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click(); //id or name is better
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        System.out.println("inside step - user enters username and password");
        driver.findElement(By.name("username")).sendKeys("testUser");
        driver.findElement(By.name("password")).sendKeys("testpassword");
        Thread.sleep(2000);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        System.out.println("inside step - user clicks on login button");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(2000);
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws Exception {
        System.out.println("inside step - user is navigated to the homepage");

        if (driver.findElement(By.name("username")).getText().contains("Hallo")){
            System.out.println("Test passed");
        }
        else{
            throw new Exception();
        }

        driver.close();
        driver.quit();

    }
}
