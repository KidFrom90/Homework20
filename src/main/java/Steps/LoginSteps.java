package Steps;

import Pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends LoginPage {
    WebDriver driver;

    public LoginSteps(WebDriver driver1) {
        driver = driver1;
    }

    public void emailInput(String s) {
        driver.findElement(emailField).sendKeys(s);
    }

    public void passwordInput(String s) {
        driver.findElement(passwordField).sendKeys(s);
    }

    public void clickEnter() {
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
    }

    public void modalPopup() {
        driver.findElement(modalTitle).sendKeys();
    }
}
