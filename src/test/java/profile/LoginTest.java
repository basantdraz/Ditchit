package profile;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    /*Test login with Valid Credentials
     * Email: namitest@gmail.com
     * Password: Nami_12
     * */

    @Test
    public void loginTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        loginPage.setEmail("namitest@gmail.com");
        loginPage.setPassword("Nami_12");
        loginPage.clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlToBe("https://ditchit.com/"));

        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, "https://ditchit.com/", "Login Failed");
    }

    /*Test login with Invalid email
     * Email: namitest12345@gmail.com
     * Password: Nami_12
     * */
    @Test
    public void failedEmailTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        loginPage.setEmail("namitest12345@gmail.com");
        loginPage.setPassword("Nami_12");
        loginPage.clickSubmitButton();

        By toastMessage = By.cssSelector("div.toastify");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        String messageText = toast.getText();
        assertTrue(messageText.contains("The selected email is invalid."), "Invalid login message not displayed");

    }

    /*Test login with Invalid email
     * Email: namitest@gmail.com
     * Password: Nami1222
     * */
    @Test
    public void failedPasswordTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        loginPage.setEmail("namitest@gmail.com");
        loginPage.setPassword("Nami1222");
        loginPage.clickSubmitButton();

        By toastMessage = By.cssSelector("div.toastify");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        String messageText = toast.getText();
        assertTrue(messageText.contains("The password is wrong"), "Wrong password message not displayed");
        toast.findElement(By.cssSelector("button.toast-close")).click();

    }

 //Test login with BlankEmail

    @Test
    public void blankEmailTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        loginPage.clickSubmitButton();
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));

        String validationMessage = (String)((JavascriptExecutor)driver)
                .executeScript("return arguments[0].validationMessage;", emailField);

        System.out.println("Validation message: " + validationMessage);
        assertEquals(validationMessage, "Please fill out this field.", "Validation message not as expected");
    }
    //Test login with Blank Password

    @Test
    public void blankPasswordTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        loginPage.setEmail("namitest@gmail.com");
        loginPage.clickSubmitButton();
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));

        String validationMessage = (String)((JavascriptExecutor)driver)
                .executeScript("return arguments[0].validationMessage;", passwordField);

        System.out.println("Validation message: " + validationMessage);
        assertEquals(validationMessage, "Please fill out this field.", "Validation message not as expected");
    }

}
