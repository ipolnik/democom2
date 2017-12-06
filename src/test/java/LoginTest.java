import com.demo.base.BaseTest;
import com.demo.pages.LoginPage;
import com.demo.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {




    @Test
    public void positiveLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedPageTitle = "Seeker Dashboard - Profile";
        String correctProfileName = "Igor Polnik";

        loginPage.openLogonPage();

        loginPage.fillUpEmailAndPassword("ipolnik@yahoo.com", "456456pro");
        // push profile button and wait page to load
        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        //Verifications
        // Verify title is correct - <title>Seeker Dashboard - Profile</title>
        System.out.println("Verification");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle), "PageTitle is not expected.\nExpected"
                + expectedPageTitle + "\nActual" + actualTitle);
        // Verify correct profile
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
    }
}