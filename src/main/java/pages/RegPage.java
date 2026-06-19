package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirm_password");
    private By email = By.id("email");
}
