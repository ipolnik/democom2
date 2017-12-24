import com.demo.base.BaseTest;
import com.demo.pages.ProfilePage;
import com.demo.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.demo.base.CsvDataProvider;
import org.testng.annotations.Test;
import com.demo.pages.LoginPage;
import java.util.Map;

public class SearchFieldTest extends BaseTest {

    @Test(dataProviderClass = CsvDataProvider.class, dataProvider = "CsvDataProvider", groups = {"positive"})

    public void findTechJobs(Map<String, String> testData) throws Exception {
        String Keywords = testData.get("Keywords");
        String zipcode_or_city = testData.get("zipcode_or_city");
        String email = testData.get("email");
        String password = testData.get("password");
        LoginPage loginPage = new LoginPage(driver, log);

        loginPage.openLogInPage();

        loginPage.fillUpEmailAndPassword(email, password);

        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        driver.findElement(By.cssSelector("#location")).clear();

        profilePage.fillUpTitleAndLocation(Keywords, zipcode_or_city);

        log.info("Seeking for Tech Jobs");

        profilePage.pushFindTechJobsButton();

        WebElement filterResults = driver.findElement(By.cssSelector("#filter-results-header"));
        log.info("Assert Search results");
        Assert.assertEquals(true, filterResults.isDisplayed());

        Thread.sleep(3000);
    }

    @Test(dataProviderClass = CsvDataProvider.class, dataProvider = "CsvDataProvider", groups = {"negative"})

    public void findTechJobsNoData(Map<String, String> testData) throws Exception {
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

        log.info("Seeking for Tech Jobs");

        profilePage.pushFindTechJobsButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver, log);

        String noJobsFoundText = searchResultPage.getNoJobsFoundText();

        Assert.assertTrue(noJobsFoundText.contains(searchResultPage.getNoJobsFoundText()), "Text not Fount");

        log.info("Please try with a different keyword or location - text shown");

        Thread.sleep(3000);

    }
}