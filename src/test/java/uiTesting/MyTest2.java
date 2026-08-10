package uiTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest2 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }
    @AfterEach
    void delete() {
        driver = null;
    }

    @ParameterizedTest
    @ValueSource(strings = {"//input[@id='userName']", "//input[@id='userEmail']",
            "//input[@id='currentAddress']", "//input[@id='permanentAddress']"})
    @DisplayName("вставка всех полей")
    void shouldFillAllField(String strings) {
        driver.get("https://demoqa.com/text-box");
        WebElement element = driver.findElement(By.xpath(strings));
        element.sendKeys("mariya");

//        element.sendKeys("2323@");
//
//        element.sendKeys("Moscow");
//
//        element.sendKeys("teplaya ulitsa");

    }
}
