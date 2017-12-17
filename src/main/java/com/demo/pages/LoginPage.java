package com.demo.pages;

import com.demo.base.PageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends PageObjects <LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("//*[@id=\"loginDataSubmit\"]/div[3]/div/button");
    private By errorMessage = By.xpath("//span[@data-automation-id='login-failure-help-message']");


    public LoginPage(WebDriver driver, Logger log) {

        super(driver, log);
    }
    public void openLogInPage(){
         getPage(URL);
    }
    public void fillUpEmailAndPassword(String email, String password){
        log.info("Filling up email and password");
     typeIn(email, emailField);
     typeIn(password, passwordField);
    }
    public ProfilePage pushSignInButton(){
        log.info("Clicking on Sign In Button");
        click(signInButton);
        return new ProfilePage(driver, log);
    }
    public String getLoginErrorMessage(){
        waitForVisibilityOf(errorMessage, 15);
        return getText(errorMessage);
    }

}
