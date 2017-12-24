import com.demo.base.BaseTest;
import com.demo.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.pages.LoginPage;
import java.util.Map;

public class SearchFieldTest extends BaseTest {

    @Test(dataProvider = "CsvDataProvider")

    public void findTechJobs(Map<String, String> testData){
        String Keywords = testData.get("Keywords");
        String zipcode_or_city = testData.get("zipcode_or_city");
        String email = testData.get("email");
        String password = testData.get("password");
        LoginPage loginPage = new LoginPage(driver, log);

        loginPage.openLogInPage();

        loginPage.fillUpEmailAndPassword(email, password);

        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        profilePage.fillUpTitleAndLocation(Keywords, zipcode_or_city);

        Assert.assertEquals("egfdgfd","gfdgfdgfdg");
    }
}
