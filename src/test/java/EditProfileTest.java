import com.demo.base.BaseTest;
import com.demo.pages.LoginPage;
import com.demo.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EditProfileTest extends BaseTest {

    @Test
    public void editProfilePage() throws Exception{

        String correctProfileName = "Igor Polnik";

        LoginPage loginPage = new LoginPage(driver, log);

        loginPage.openLogInPage();

        loginPage.fillUpEmailAndPassword("ipolnik@yahoo.com", "456456pro");

        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
        
        profilePage.pushEditButton();

        Thread.sleep(5000);

        WebElement editFirstName = driver.findElement(By.cssSelector("button.hidden-sm"));
        log.info("Assert Edit Name");
        Assert.assertEquals(true, editFirstName.isDisplayed());

        /*WebElement element = driver.findElement(By.xpath("//*[@id=\"profileForm\"]/div[2]/div/div/section[5]/div/div/span/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);*/

        //Assert.assertTrue(profilePage.isProfileEdited(correctManageLetterText));

       profilePage.pushDoneProfileButton();

       log.info("Assert profile is saved");

        WebElement profileSaved = driver.findElement(By.cssSelector(".dashboardSaveMsg > span:nth-child(2)"));
        log.info("Assert profile Saved");
        Assert.assertEquals(true, profileSaved.isDisplayed());

    }
}
