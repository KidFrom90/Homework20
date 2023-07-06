package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class ChromeRider {
    public static WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openChrome() {
        driver.manage().window().maximize();
        driver.get("https://www.copart.com/login/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
    }

    @AfterTest
    public void closeChrome() {
        driver.quit();
    }


}
