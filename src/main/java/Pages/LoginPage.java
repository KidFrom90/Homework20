package Pages;

import org.openqa.selenium.By;

public class LoginPage {
    public By
            emailField = By.id("username"),
            passwordField = By.id("password"),
            modalTitle = By.xpath("//h3[@class='modal-title bold']"),
            errorSpan = By.xpath("//span[@data-uname='userLoginAlertMessage']");
}
