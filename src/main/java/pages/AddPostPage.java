package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddPostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nextBtn = By.xpath("//button[normalize-space()='Next']");
    private By previosBtn = By.xpath("//button[normalize-space()='Previous']");
    private By confirmPublishButton = By.xpath("//button[normalize-space()='Confirm & Publish']");
    //Methods to click buttons
    public void clickNext() {
        //wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        WebElement next = wait.until(
                ExpectedConditions.presenceOfElementLocated(nextBtn)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", next
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", next
        );
    }
    public void clickPrevious() {
        wait.until(ExpectedConditions.elementToBeClickable(previosBtn)).click();
    }
    public void clickConfirmPublish() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPublishButton)).click();
    }


    // Method to select any category Step1
    private By categoryByName(String categoryName) {
        return By.xpath("//label[.//span[normalize-space()='" + categoryName + "']]");
    }
    public void chooseCategory(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryByName(name))).click();
    }


    //Methods to fill attributes of Step2

    //1. upload image
    private By uploadInput = By.xpath("//input[@type='file' and @accept='image/*']");
    public void uploadImage(String imagePath){
        driver.findElement(uploadInput).sendKeys(imagePath);
    }

    //2.Title
    private By inputTitle = By.id("title");
    public void setTitle(String title) {
         driver.findElement(inputTitle).sendKeys(title);
    }
    //3.Description
    private By inputDescription = By.id("description");
    public void setDescription(String description) {
        driver.findElement(inputDescription).sendKeys(description);
    }
    /*
    //Location Suspend
    */
    //4.Location
    private By countryDropdown = By.id("country_id");
    private By optionByText(String countryName) {
        return By.xpath("//div[@role='option' and normalize-space(text())='" + countryName + "']");
    }
    public void selectCountry(String countryName) {
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", dropdown);

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionByText(countryName)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", option);

    }

    private By searchInput = By.xpath("//input[@placeholder='Search']");
    public void typeInSearch(String value) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear();
        input.sendKeys(value);
        System.out.println("Typed '" + value + "' in search input");
    }





    //Method to set condition at Step3
    private By conditionDropdown = By.id("condition");
    public void selectCondition(String conditionName){
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(conditionDropdown));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        By option = By.xpath("//*[@role='option' and normalize-space()='" + conditionName + "']");

        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(option));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    //Methods to fill attributes at Step4

    //1.Price
    private By priceInput = By.id("price");
    public void setPrice(String price) {
        driver.findElement(priceInput).sendKeys(price);
    }
    //2.checkboxes
    // this methods will check and uncheck by id for each box
    // ("firm_price","virtual_tour")
    public void checkCheckbox(String checkboxId) {
        By checkbox = By.id(checkboxId);
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(checkbox));
        // Check current state
        String state = element.getAttribute("aria-checked");
        if (!state.equals("true")) {
            element.click();
        }
    }
    public void uncheckCheckbox(String checkboxId) {
        By checkbox = By.id(checkboxId);
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(checkbox));
        String state = element.getAttribute("aria-checked");
        if (state.equals("true")) {
            element.click();
        }
    }

    //3.Delivery method
    private By deliveryByName(String name) {
        return By.xpath("//label[normalize-space()='" + name + "']");
    }
    public void chooseDelivery(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(deliveryByName(name))).click();
    }

    //PopScreen
    public void skipAndPublishPopup() {
        By dialog = By.xpath("//div[@role='dialog' and @data-state='open']");
        By skipBtn = By.xpath("//div[@role='dialog' and @data-state='open']//button[contains(text(),'Skip & Publish')]");
        WebElement popup = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(dialog));
        WebElement skip = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(skipBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", skip);
        System.out.println("Popup detected and Skip & Publish clicked");
    }


    public AddPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }

}
