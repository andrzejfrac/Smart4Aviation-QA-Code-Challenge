package smart4aviation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import smart4aviation.utilities.TestUser;

public class RegistrationPage {
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String CONFIRM_PASSWORD = "ConfirmPassword";
    private static final String REGISTER_BUTTON = "register-button";
    private static final String rEGISTER_NEXT_STEP_BUTTON = "button-1";
    private WebDriver webDriver;
    private HomePage homePage;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver webDriver, HomePage homePage) {
        this.webDriver = webDriver;
        this.homePage = homePage;
        this.wait = new WebDriverWait(webDriver, 4000);
    }

    public HomePage register(TestUser testUser) {
        webDriver.findElement(By.id(FIRST_NAME)).sendKeys(testUser.getFirstName());
        webDriver.findElement(By.id(LAST_NAME)).sendKeys(testUser.getLastName());
        webDriver.findElement(By.id(EMAIL)).sendKeys(testUser.getEmail());
        webDriver.findElement(By.id(PASSWORD)).sendKeys(testUser.getPassword());
        webDriver.findElement(By.id(CONFIRM_PASSWORD)).sendKeys(testUser.getPassword());
        webDriver.findElement(By.id(REGISTER_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className(rEGISTER_NEXT_STEP_BUTTON)));
        webDriver.findElement(By.className(rEGISTER_NEXT_STEP_BUTTON)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
        return homePage;
    }
}