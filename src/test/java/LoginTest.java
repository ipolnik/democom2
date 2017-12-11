import com.demo.base.BaseTest;
import com.demo.base.CsvDataProvider;
import com.demo.pages.LoginPage;
import com.demo.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedPageTitle = "Seeker Dashboard - Profile";
        String correctProfileName = "Igor Polnik";

        loginPage.openLogInPage();

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

    @Test (dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLogin(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect";
        String testNumber = testData.get("No");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("Description");

        System.out.println("Test number: " + testNumber + "n\for " + description + "Wheren\nemail " + email + "And password\n" + password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogInPage();

        loginPage.fillUpEmailAndPassword(email, password);
        // push sign in button
          loginPage.pushSignInButton();

          String errorMessage = loginPage.getLoginErrorMessage();

        Assert.assertTrue(errorMessage.contains(expectedErrorMessage), "Error message is not expected.\nExpected"
                + expectedErrorMessage + "\nActual" + errorMessage);

}


}
