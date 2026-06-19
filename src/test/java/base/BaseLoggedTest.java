package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;

public class BaseLoggedTest {
    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://ditchit.com");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickProfileIcon();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
        loginPage.setEmail("namitest2@gmail.com");
        loginPage.setPassword("Nami_12");
        loginPage.clickSubmitButton();
        wait.until(ExpectedConditions.urlToBe("https://ditchit.com/en"));
    }

   /* @AfterClass
    public void tearDown(){
        driver.quit();
    }*/

    public WebDriver getDriver() {
        return driver;
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
}
