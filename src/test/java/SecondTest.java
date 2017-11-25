import com.demo.base.BaseTest;
import org.testng.annotations.Test;


public class SecondTest extends BaseTest {
    @Test
    public void secondMethod() {
        driver.get("http://www.linkedin.com");

        System.out.println("website opened!");
    }
}
