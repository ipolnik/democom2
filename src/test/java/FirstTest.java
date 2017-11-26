
import com.demo.base.BaseTest;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void firstMethod() {

        driver.get("http://www.google.com");

        System.out.println("website opened!");

    }


}

