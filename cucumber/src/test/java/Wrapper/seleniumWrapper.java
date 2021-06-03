package Wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class seleniumWrapper {
    WebDriver driver = null;
    public WebElement findWebElementWithText(String text) {
        return driver.findElement(By.xpath(".//*[contains(.,'$text')]"));
    }
    public WebElement findElementWithId(String id){
        return driver.findElement(By.id(id));
    }
    public WebElement findWebButtonWithText(String text){
        return driver.findElement(By.xpath(".//button[contains(.,'"+text+"')]"));
    }
    public WebElement findWebElementWithPlaceholderText(String text) {
        return driver.findElement(By.xpath(".//*[@placeholder='"+text+"']"));
    }

    public void setDriver(){
        driver = new ChromeDriver();
    }
    public void setTimeout(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
    public void navigateTo(String url){
        driver.navigate().to(url);
    }
}
