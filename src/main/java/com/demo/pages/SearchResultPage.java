package com.demo.pages;

import com.demo.base.PageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends PageObjects<ProfilePage> {
    private By noJobsFound = By.xpath("/html/body/div[6]/div[2]/div/h2");

    public SearchResultPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getNoJobsFoundText(){
        driver.findElement(noJobsFound).getText();
        return getText(noJobsFound);
    }
}
