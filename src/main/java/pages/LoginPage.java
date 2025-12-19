package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    /**
     * Login Page ElementSelectors
     *
     */
    private WebDriver driver;
    private By emailField = By.cssSelector("input[name='email']");
    private By passwordField = By.cssSelector("input[name='password']");
    private By submitButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        By overlay = By.cssSelector(".modal-backdrop");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

        WebElement btn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(submitButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn);
    }


}
