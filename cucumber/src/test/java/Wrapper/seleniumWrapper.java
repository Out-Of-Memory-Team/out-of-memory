package Wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class seleniumWrapper {
    WebDriver driver = null;
    public WebElement findWebElementWithText(String text) {
        return driver.findElement(By.xpath("//*[contains(.,'"+text+"')]"));
    }
    public WebElement findElementWithId(String id){
        return driver.findElement(By.id(id));
    }
    public WebElement findInputWithId(String id){
        return driver.findElement(By.xpath(".//input[@id='"+id+"']"));
    }
    public WebElement findWebButtonWithText(String text){
        return driver.findElement(By.xpath(".//button[contains(.,'"+text+"')]"));
    }
    public WebElement findWebElementWithPlaceholderText(String text) {
        return driver.findElement(By.xpath(".//*[@placeholder='"+text+"']"));
    }
    public void writeFrontAndBack(String placeholder, String frontSite, String backSite) {
       List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@data-placeholder='"+placeholder+"']"));
       listOfElements.get(0).sendKeys(frontSite);
       listOfElements.get(1).sendKeys(backSite);
    }
    public WebElement findWebSpanWithText(String text) {
        return driver.findElement(By.xpath("//span[contains(.,'"+text+"')]"));
    }
    public WebElement findWebDivWithText(String text) {
        return driver.findElement(By.xpath("//div[contains(.,'"+text+"')]"));
    }
    public WebElement findClrOptionWithText(String text){
            return driver.findElement(By.xpath(".//clr-option[contains(.,'"+text+"')]"));
    }
    public WebElement findInput(){
        return driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
    }
    public WebElement findWebIconWithShape(String shape) {
        return driver.findElement(By.xpath("//clr-icon[contains(@shape,'"+shape+"')]"));
    }
    public WebElement findWebIconWithShapeAfterDivWithClass(String parentDivClass, String shape) {
        return driver.findElement(By.xpath("//div[@class='"+parentDivClass+"']//clr-icon[contains(@shape,'"+shape+"')]"));
    }
    public WebElement findWebCellWithText(String text) {
        return driver.findElement(By.xpath("//clr-dg-cell[contains(.,'"+text+"')]"));
    }

    public void scrollToBottom(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
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
    public void closeBrowser(){

        driver.close();
        driver.quit();
    }
}
