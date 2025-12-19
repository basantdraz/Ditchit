package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private  WebDriver driver;
    public HomePage(WebDriver driver){this.driver=driver;}

//Moving to Login / Logout icon
public  LoginPage clickProfileIcon(){
    driver.findElement(By.id("myAccount")).click();
    return new LoginPage(driver);
}

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}





