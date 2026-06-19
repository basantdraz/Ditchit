package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private  WebDriver driver;
    public HomePage(WebDriver driver){this.driver=driver;}

//Moving to Login / Logout icon

public  LoginPage clickProfileIcon(){
    By loginIcon = By.cssSelector("a[href='/en/login']");
   driver.findElement(loginIcon).click();
    return new LoginPage(driver);
}
//Moving to Add Post Button

public AddPostPage clickAddPost(){
        By addPostIcon = By.xpath("//button[normalize-space()='Add Post']");
        driver.findElement(addPostIcon).click();
        return new AddPostPage(driver);
}

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}





