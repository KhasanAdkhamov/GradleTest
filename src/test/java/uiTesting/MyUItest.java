package uiTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyUItest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void myTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element = driver.findElement(By.xpath("//input[@id='firstName']"));
        element.sendKeys("1212aleks");
        WebElement element2 = driver.findElement(By.xpath("//*[@id='lastName']"));
        element2.sendKeys("semenov");
        WebElement element3 = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        element3.sendKeys("moscow lubyanka");
    }

    @Test
    public void calendarTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
        element.click();
        WebElement webElement = driver.findElement(By.className("react-datepicker__month-select"));
        webElement.click();
        Select select = new Select(webElement);
        select.selectByVisibleText("May");
        WebElement yearArea = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectForYear = new Select(yearArea);
        selectForYear.selectByVisibleText("2035");
        WebElement dayOfElement = driver.findElement(By.xpath("//*[text()='5' and contains(@class,'react-datepicker__day')]"));
        dayOfElement.click();
        //WebElement element2 = driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        //element2.click();
    }

    @Test
    void genderTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement elementMale = driver.findElement(By.className("form-check-label"));
        elementMale.click();

    }

    @Test
    void stateAndCityTest() {
        driver.get("https://demoqa.com/automation-practice-form");

    }

}
