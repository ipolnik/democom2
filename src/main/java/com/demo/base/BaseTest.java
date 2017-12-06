package com.demo.base;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;

import java.util.Arrays;


public class BaseTest {
    protected WebDriver driver;


    @BeforeTest
    protected void methodSetUp() {
        System.out.println("Method set up...");
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


   @AfterMethod
    protected void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File("C:\\Users\\ipolnik\\IdeaProjects" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
     driver.quit();
    }
}
