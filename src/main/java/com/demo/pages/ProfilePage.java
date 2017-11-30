package com.demo.pages;

import com.demo.base.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends PageObjects<ProfilePage> {
    private By editProfileButton = By.xpath("//*[@id=\"editProfile\"]");
    private By advancedSearchButton = By.xpath("//*[@id=\"advanced-search-link\"]");
    private By profileContactNameText = By.xpath("//h1[@class=\'profile-contact-name']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public void waitForProfilePageToLoad(){
        System.out.println("Waiting for Profile page to load");
     waitForVisibilityOf(editProfileButton);
     waitForVisibilityOf(advancedSearchButton, 10);
    }
    public boolean isCorrectProfileLoaded (String correctProfileName){
        if (getText(profileContactNameText).equals(correctProfileName)){
            return true;
        }
        return false;
    }
}
