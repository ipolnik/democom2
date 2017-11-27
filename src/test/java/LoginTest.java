import com.demo.base.BaseTest;
import com.demo.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Created by ipolnik on 11/26/2017.
 */
public class LoginTest extends BaseTest {


    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void positiveLogin() {

        loginPage.openLogonPage();

        loginPage.fillUpEmailAndPassword("ipolnik@yahoo.com", "456456pro");

        loginPage.pushSignInButton();


    }
}