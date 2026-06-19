package profile;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RegisterTest extends BaseTests {
    @Test
    public void RegisterTest()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));

    }
}
