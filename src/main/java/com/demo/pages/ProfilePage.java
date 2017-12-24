package com.demo.pages;

import com.demo.base.PageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends PageObjects<ProfilePage> {
    private By editProfileButton = By.xpath("//*[@id=\"editProfile\"]");
    private By advancedSearchButton = By.xpath("//*[@id=\"advanced-search-link\"]");
    private By profileContactNameText = By.xpath("//h1[@class=\'profile-contact-name']");
    private By doneProfileButton = By.cssSelector("button.hidden-sm");
    private By manageCoverLetters = By.xpath("//[class=\'btn btn-default btn-lg pull-right hidden-xs hidden-sm ng-scope']");
   // private By assertEditFirstName = By.xpath("//*[@id=\\\"contactFirstNameInput\\\"]");


    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void waitForProfilePageToLoad(){
        log.info("Waiting for Profile page to load");
     waitForVisibilityOf(editProfileButton);
     waitForVisibilityOf(advancedSearchButton, 10);
    }

    public ProfilePage pushEditButton() {
        log.info("Clicking on Edit button");
        click(editProfileButton);
        return new ProfilePage(driver, log);}

    public ProfilePage pushDoneProfileButton() {
        log.info("Clicking on Done button");
        click(doneProfileButton);
        return new ProfilePage(driver, log);
    }

    public boolean isCorrectProfileLoaded (String correctProfileName){
        if (getText(profileContactNameText).equals(correctProfileName)){
            return true;
        }

        return false;
    }
    /*public boolean isFirstNameEdited (String assertFirstName) {
        if (getText(assertEditFirstName).equals(assertFirstName)) {
            return true;
        }
        return false;*/
    }




