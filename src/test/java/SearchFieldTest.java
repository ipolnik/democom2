import com.demo.base.BaseTest;
import com.demo.pages.ProfilePage;
import org.testng.annotations.Test;
import com.demo.pages.LoginPage;
import java.util.Map;

public class SearchFieldTest extends BaseTest {

    @Test(dataProvider = "CsvDataProvider")

    public void findTechJobs(Map<String, String> testData){
        String Keywords = testData.get("Keywords");
        String zipcode_or_city = testData.get("zipcode_or_city");
        LoginPage loginPage = new LoginPage(driver, log);
        String email = "ipolnik@yahoo.com";
        String password = "456456pro";

        loginPage.openLogInPage();

        loginPage.fillUpEmailAndPassword(email, password);

        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();



    }
}
