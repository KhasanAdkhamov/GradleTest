package uiTesting.pom.hw.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import uiTesting.pom.TextBookPage;

public class TextFormPage {
    private WebDriver driver;
    private final By nameLocator = By.xpath("//*[@id='firstName']");
    private final By lastNameLocator = By.xpath("//*[@id='lastName']");
    private final By emailLocator = By.xpath("//*[@id='userEmail']");
    private final By genderMaleLocator = By.xpath("//*[@id='gender-radio-1']");
    private final By numberLocator = By.xpath("//*[@id='userNumber']");
    private final By dayOfBirthLocator = By.xpath("//*[@id='dateOfBirthInput']");
    private final By selectMonthsLocator = By.className("react-datepicker__month-select");
    private final By selectYearsLocator = By.className("react-datepicker__year-select");
    private final By hobbiesLocator = By.xpath("//*[@id=hobbies-checkbox-1']");
    private final By currentAddressLocator = By.xpath("//*[@id='currentAddress']");
    private final By submitLocator = By.xpath("//*[@id='submit']");


    public TextFormPage(WebDriver driver) {
        this.driver = driver;
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

    public TextFormPage setSubmit() {
        driver.findElement(submitLocator).click();
        return this;
    }

    public TextFormPage open() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }
}
