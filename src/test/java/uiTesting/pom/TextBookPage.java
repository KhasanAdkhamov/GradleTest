package uiTesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBookPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private final By fullNameLocator = By.xpath("//*[@id='userName']");
    private final By emailLocator = By.xpath("//*[@id='userEmail']");
    private final By currentAddress = By.xpath("//*[@id='currentAddress']");
    private final By permanentAddress = By.xpath("//*[@id='permanentAddress']");
    private final By submit = By.xpath("//*[@id='submit']");

    public TextBookPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public TextBookPage setFullName(String name) {
        WebElement nameElement = driver.findElement(fullNameLocator);
        nameElement.sendKeys(name);
        return this;
    }

    public TextBookPage setFullCurrentAddress(String name) {
        WebElement nameElement = driver.findElement(currentAddress);
        nameElement.sendKeys(name);
        return this;
    }

    public TextBookPage setFullPermanentAddress(String name) {
        WebElement nameElement = driver.findElement(permanentAddress);
        nameElement.sendKeys(name);
        return this;
    }

    public TextBookPage setFullEmail(String name) {
        WebElement nameElement = driver.findElement(emailLocator);
        nameElement.sendKeys(name);
        return this;
    }


    public TextBookPage open() {
        driver.get("https://demoqa.com/text-box");
        return this;
    }

}
