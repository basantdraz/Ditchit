package addPost;

import base.BaseLoggedTest;
import org.testng.annotations.Test;
import pages.AddPostPage;
import pages.HomePage;

public class AddPostTest extends BaseLoggedTest {
    @Test
    public void AddpostTest() {
        HomePage homePage = new HomePage(driver);
        AddPostPage addPostPage = homePage.clickAddPost();
        addPostPage.chooseCategory("Furniture");
        addPostPage.clickNext();
        addPostPage.uploadImage("C:\\Users\\namit\\OneDrive\\Desktop\\Test\\1.jfif");
        addPostPage.setTitle("Title automation test");
        addPostPage.setDescription("Description automation test test");
        addPostPage.typeInSearch("95HJ3285+M8");
        //addPostPage.selectCountry("India");
       // addPostPage.typeInSearch("9M29+C3 Tamia, Madhya Pradesh, India");
        addPostPage.clickNext();
        addPostPage.selectCondition("New");
        addPostPage.clickNext();
        addPostPage.setPrice("10");
        addPostPage.checkCheckbox("firm_price");
        addPostPage.chooseDelivery("Local");
        addPostPage.clickConfirmPublish();
        addPostPage.skipAndPublishPopup();
    }
}

