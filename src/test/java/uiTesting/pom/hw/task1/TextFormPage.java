package uiTesting.pom.hw.task1;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextFormPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private final By nameLocator = By.xpath("//*[@id='firstName']");
    private final By lastNameLocator = By.xpath("//*[@id='lastName']");
    private final By emailLocator = By.xpath("//*[@id='userEmail']");
    private final By genderMaleLocator = By.xpath("//*[@id='gender-radio-1']");
    private final By numberLocator = By.xpath("//*[@id='userNumber']");
    private final By dayOfBirthLocator = By.xpath("//*[@id='dateOfBirthInput']");
    private final By selectMonthsLocator = By.className("react-datepicker__month-select");
    private final By selectYearsLocator = By.className("react-datepicker__year-select");
    private final By hobbiesLocator = By.xpath("//*[@id='hobbies-checkbox-1']");
    private final By currentAddressLocator = By.xpath("//*[@id='currentAddress']");
    private final By subjectLocator = By.xpath("//*[@id='subjectsContainer']//input");
    private final By subjectMathsLocator = By.xpath("//*[@id='react-select-2-option-0']");
    private final By dayOfClassLocator = By.xpath("//*[text()='5' and contains(@class,'react-datepicker__day')]");
    private final By submitLocator = By.xpath("//*[@id='submit']");


    public TextFormPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public TextFormPage setName(String string) {
        WebElement element = driver.findElement(nameLocator);
        element.sendKeys(string);
        return this;
    }

    public TextFormPage setLastName(String string) {
        driver.findElement(lastNameLocator).sendKeys(string);
        return this;
    }

    public TextFormPage setEmail(String string) {
        driver.findElement(emailLocator).sendKeys(string);
        return this;
    }

    public TextFormPage setGender() {
        WebElement element = driver.findElement(genderMaleLocator);
        element.click();
        return this;
    }

    public TextFormPage setNumber(String number) {
        driver.findElement(numberLocator).sendKeys(number);
        return this;
    }

    public TextFormPage setDayOfBirth(String month, String year) {
        WebElement element = driver.findElement(dayOfBirthLocator);
        element.click();
        WebElement monthElement = driver.findElement(selectMonthsLocator);
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByVisibleText(month);
        WebElement yearElement = driver.findElement(selectYearsLocator);
        Select selectYear = new Select(yearElement);
        selectYear.selectByVisibleText(year);
        driver.findElement(dayOfClassLocator).click();
        return this;
    }

    public TextFormPage setSubject(String string) throws InterruptedException {
        WebElement elementLocatorSubject = driver.findElement(subjectLocator);
        elementLocatorSubject.sendKeys(string);
        driverWait.until(ExpectedConditions.elementToBeClickable(subjectMathsLocator));
        elementLocatorSubject.sendKeys(Keys.ENTER);
        //driverWait.until(ExpectedConditions.elementToBeClickable(subjectLocator)).sendKeys(Keys.ENTER);
        return this;
    }

    public TextFormPage setHobbies() {
        driver.findElement(hobbiesLocator).click();
        return this;
    }

    public TextFormPage setAddress(String string) {
        driver.findElement(currentAddressLocator).sendKeys(string);
        return this;
    }

    public TextFormPage clickSubmit() {
        WebElement element = driver.findElement(submitLocator);
        scroll(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return this;
    }

    public TextFormPage open() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }

    public TextFormPage scroll(WebElement element) {
        Actions action = new Actions(driver, Duration.ofSeconds(5));
        //action.scrollToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
        return this;
    }
}
