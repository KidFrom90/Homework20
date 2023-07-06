import Steps.LoginSteps;
import Utilities.ChromeRider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Data.LoginData.*;
import java.time.Duration;


public class Login extends ChromeRider {
    @Test (testName = "a")
    public void loginWithCorrectData() {

        LoginSteps step1 = new LoginSteps(driver);
        step1.emailInput(correctEmail);
        step1.passwordInput(correctPassword);
        step1.clickEnter();

        By modalTitle = By.xpath("//h3[@class='modal-title bold']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));

        String actualMsg = element.getText();
        String expectedMsg = "Complete Registration";

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test (testName = "b")
    public void loginWithIncorrectData() {
        LoginSteps step2 = new LoginSteps(driver);
        step2.emailInput(incorrectEmail);
        step2.passwordInput(correctPassword);
        step2.clickEnter();

        By errorSpan = By.xpath("//span[@data-uname='userLoginAlertMessage']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorSpan));

        String actualErrorMsg = errorElement.getText();
        String expectedErrorMsg = "Unable to continue. The following error needs to be corrected:The User ID or password provided is incorrect";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}


// These are tests before splitting them into packages

/*  @Test (priority = 2)
    public static void loginWithCorrectData1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.copart.com/login/");

        By
                emailInput = By.id("username"),
                passwordInput = By.id("password"),
                modalTitle = By.xpath("//h3[@class='modal-title bold']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));

        driver.findElement(emailInput).sendKeys("george_nachkebia@yahoo.com");
        driver.findElement(passwordInput).sendKeys("Mobrdzandi1");
        driver.findElement(passwordInput).sendKeys(Keys.ENTER);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        String actualMsg = element.getText();
        String expectedMsg = "Complete Registration";

        Assert.assertEquals(actualMsg, expectedMsg);

        driver.quit();
    }


    @Test (priority = 1)
    public static void loginWithIncorrectData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.copart.com/login/");

        By
                emailInput = By.id("username"),
                passwordInput = By.id("password"),
                errorSpan = By.xpath("//span[@data-uname='userLoginAlertMessage']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));

        driver.findElement(emailInput).sendKeys("g_nachkebia@yahoo.com");
        driver.findElement(passwordInput).sendKeys("Mobrdzandi1");
        driver.findElement(passwordInput).sendKeys(Keys.ENTER);

        String actualErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorSpan)).getText();
        String expectedErrorMsg = "Unable to continue. The following error needs to be corrected:The User ID or password provided is incorrect";

        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);

        driver.quit();
    }
*/

