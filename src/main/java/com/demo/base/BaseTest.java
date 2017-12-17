package com.demo.base;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx){
    String testName = ctx.getCurrentXmlTest().getName();
    log = Logger.getLogger(testName);
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser" })
    protected void methodSetUp(String browser) {
        log.info("Method set up...");
        driver = BrowserFactory.getDriver(browser, log);

    }

   @AfterMethod(alwaysRun = true)

    protected void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File("C:\\Users\\ipolnik\\IdeaProjects" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }

    }
  @AfterMethod (alwaysRun = true)
    protected void methodTearDown(){
      log.info("Method teardown");
        driver.quit();
    }
}
